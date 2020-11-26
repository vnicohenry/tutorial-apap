package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.repository.KamarDb;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{
    @Autowired
    private KamarDb kamarDb;

    @Override
    public KamarModel createKamar(KamarModel kamar){
        return kamarDb.save(kamar);
    }

    @Override
    public KamarModel getKamarByNoKamar(Long noKamar) {
        Optional<KamarModel> kamar = kamarDb.findById(noKamar);
        if(kamar.isPresent()){
            return kamar.get();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public KamarModel changeKamar(Long noKamar, KamarModel kamarUpdate){
        KamarModel kamar = getKamarByNoKamar(noKamar);
        kamar.setKapasitasKamar(kamarUpdate.getKapasitasKamar());
        kamar.setTipe(kamarUpdate.getTipe());
        kamar.setNamaKamar(kamarUpdate.getNamaKamar());
        return kamarDb.save(kamar);
    }

    @Override
    public List<KamarModel> retrieveListKamar() {
        return kamarDb.findAll();
    }

    @Override
    public void deleteKamar(Long noKamar){
        KamarModel kamar = getKamarByNoKamar(noKamar);
        kamarDb.delete(kamar);
    }

}
