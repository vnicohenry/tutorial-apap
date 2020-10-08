package apap.tutorial.traveloke.controller;
import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotel(
            // Request parameter yang ingin dibawa
            @RequestParam(value= "idHotel", required = true) String idHotel,
            @RequestParam(value= "namaHotel", required = true) String namaHotel,
            @RequestParam(value= "alamat", required = true) String alamat,
            @RequestParam(value= "noTelepon", required = true) String noTelepon,
            Model model
    ){
        // Membuat objek HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        // Memanggil service addHotel
        hotelService.addHotel(hotel);

        // Add variabel id hotel ke 'idHotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);

        // Return view template yang digunakan
        return "add-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymeleaf
        model.addAttribute("listHotel", listHotel);

        // Return view template yang diinginkan
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value= "idHotel") String idHotel,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        // Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "view-hotel";
    }

    @RequestMapping("/hotel/view/id-hotel/{idHotel}")
    public String detailHotelSingkat(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        // Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
        model.addAttribute("hotel", hotel);

        if(hotel != null){
            return "view-hotel";
        }
        else{
            return "notFound";
        }
    }

    @RequestMapping("/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    public String updatePhoneNumber(
            @PathVariable(value= "idHotel") String idHotel,
            @PathVariable(value= "noTelepon") String noTelepon,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        // Add variabel HotelModel ke 'hotel' untuk dirender pada thymeleaf
        model.addAttribute("hotel", hotel);

        // Mengecek apakah hotel dengan id tersebut ada
        if(hotel != null){
            hotel.setNoTelepon(noTelepon);
            return "noTeleponUpdate";
        }
        else{
            return "notFound";
        }
    }

    @RequestMapping("/hotel/delete/id-hotel/{idHotel}")
    public String deleteHotelById(
            @PathVariable(value= "idHotel") String idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        System.out.println(hotel.getIdHotel());

        model.addAttribute("hotel", hotel);

        if(hotel != null){
            hotelService.deleteHotel(idHotel);
            return "deleteHotel";
        }
        else{
            return "notFound";
        }

    }

    @RequestMapping("/hotel/deleteAll")
    public String deleteSemuaHotel(Model model){

        // Menghapus semua instance Hotel
        hotelService.deleteAllHotel();

        return "deleteAllHotel";
    }



}
