package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.security.UserDetailsServiceImpl;
import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(
            @ModelAttribute UserModel user, String password,
            Model model){

        if(userService.validatePassword(password)){
            userService.addUser(user);
            model.addAttribute("user", user);
            return "redirect:/";
        }
        else{
            String salah = "Password harus mengandung huruf, angka, dan minimal 8 karakter!";
            model.addAttribute("message", salah);

            boolean addUser = false;

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority ga : authorities){
                if(ga.getAuthority().equals("ADMIN")){
                    addUser = true;
                }
            }

            model.addAttribute("addUser", addUser);
            model.addAttribute("listRole", roleService.findAll());
            return "home";
        }


    }

    @RequestMapping(value = "/updatePassword")
    public String updatePasswordForm(
            Model model
    ){

        return "updatePassword";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePasswordSubmit(
            @ModelAttribute UserModel userModel,
            String oldPassword, String newPassword, String confirmNewPassword,
            HttpServletRequest request,
            Model model
    ) throws ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserModel user = userService.findUserByUsername(username);
        if(userService.passwordMatch(oldPassword, user)){
            if(newPassword.equals(confirmNewPassword)){
                if(userService.validatePassword(newPassword)){
                    user.setPassword(newPassword);
                    userService.addUser(user);
                    request.logout();
                    model.addAttribute("messageSukses", "Password berhasil diubah.");
                    return "login";
                }
                else{
                    model.addAttribute("message", "Password harus mengandung huruf, angka, dan minimal 8 karakter!");
                }
            }
            else{
                model.addAttribute("message", "Password tidak cocok!");
            }
        }
        else{
            String salah = "Password lama salah!";
            model.addAttribute("message", salah);
        }
        return "updatePassword";
    }
}
