package apap.tutorial.traveloke.service;
import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService{

    private List<HotelModel> listHotel;

    //Constructor
    public HotelInMemoryService() {
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel) {
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList() {
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel){
        for (int i = 0 ; i < listHotel.size() ; i++){
            if(listHotel.get(i).getIdHotel().equals(idHotel)) {
                return listHotel.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteHotel(String idHotel) {
        HotelModel hotel = getHotelByIdHotel(idHotel);
        listHotel.remove(hotel);
    }

    @Override
    public void deleteAllHotel(){
        listHotel.clear();
    }
}
