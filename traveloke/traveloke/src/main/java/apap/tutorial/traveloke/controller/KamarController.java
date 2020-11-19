package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

//    @GetMapping("/kamar/add/{idHotel}")
//    private String addKamarFormPage(
//            @PathVariable Long idHotel,
//            Model model
//    ){
//        KamarModel kamar = new KamarModel();
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        kamar.setHotel(hotel);
//        int jumlahBaris = 1;
//        model.addAttribute("kamar", kamar);
//        model.addAttribute("jumlahKolom", jumlahBaris);
//
//        return "form-add-kamar";
//    }

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
//        Long jumlahBaris = (long) 5;
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        kamar.setHotel(hotel);
        ArrayList<KamarModel> kumpulanKamarBaru = new ArrayList<KamarModel>();
        kumpulanKamarBaru.add(kamar);
        hotel.setListKamar(kumpulanKamarBaru);
        model.addAttribute("kamar", kamar);
//        model.addAttribute("jumlahBaris", jumlahBaris);
        model.addAttribute("hotel", hotel);

        return "form-add-kamar";
    }

//    @PostMapping("/kamar/add")
//    private String addKamarSubmit(
//            @ModelAttribute KamarModel kamar,
//            Model model
//    ){
//        kamarService.addKamar(kamar);
//        model.addAttribute("noKamar", kamar.getNoKamar());
//        return "add-kamar";
//    }

    @PostMapping(value="/kamar/add", params={"simpan"})
    private String addKamarSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        for(KamarModel kamar : hotel.getListKamar()){
            kamar.setHotel(hotel);
            kamarService.addKamar(kamar);
        }
        model.addAttribute("jumlah", hotel.getListKamar().size());
        return "add-kamar";
    }

    @PostMapping(value="/kamar/add", params={"addRow"})
    private String addRowKamar(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        if(hotel.getListKamar() == null){
            hotel.setListKamar(new ArrayList<KamarModel>());
        }
        KamarModel kamar = new KamarModel();

        hotel.getListKamar().add(kamar);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value="/kamar/add", params={"deleteRow"})
    private String deleteRowKamar(
            @ModelAttribute HotelModel hotel,
            final HttpServletRequest req,
            Model model
    ){
        int id = Integer.valueOf(req.getParameter("deleteRow"));
        hotel.getListKamar().remove(id);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model
    ){
        KamarModel kamar = kamarService.findKamarByNomorKamar(noKamar);
        model.addAttribute("kamar", kamar);
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarUpdated = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "update-kamar";
    }

//    @RequestMapping("/kamar/delete/{noKamar}")
//    public String deleteKamar(
//            @PathVariable(value= "noKamar") Long noKamar,
//            Model model
//    ){
//        KamarModel kamar = kamarService.findKamarByNomorKamar(noKamar);
//
//        model.addAttribute("kamar", kamar);
//
//        kamarService.deleteKamar(kamar);
//        return "deleteKamar";
//    }
//
//    @PostMapping("/kamar/delete")
//    public String deleteKamarFormSubmit(
//            @ModelAttribute HotelModel hotel,
//            Model model
//    ){
//        model.addAttribute("kamarCount", hotel.getListKamar().size());
//
//        for(KamarModel kamar : hotel.getListKamar()){
//            model.addAttribute("idHotel", kamar.getHotel().getId());
//            kamarService.deleteKamar(kamar);
//        }
//        return "deleteKamar";
//    }
}
