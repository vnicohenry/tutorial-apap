package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public boolean passwordMatch(String oldPassword, UserModel user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldPassword, user.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean validatePassword(String password){
        return password.matches("(?=.*[0-9])(?=.*[A-Za-z]).{8,}");
    }

    @Override
    public UserModel findUserByUsername(String username){
        UserModel user = userDb.findByUsername(username);
        if(user != null){
            return user;
        }
        else{
            return null;
        }
    }

}
