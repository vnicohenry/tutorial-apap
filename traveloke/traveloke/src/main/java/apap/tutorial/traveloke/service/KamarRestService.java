package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface KamarRestService {
    KamarModel createKamar(KamarModel kamar);

    List<KamarModel> retrieveListKamar();

    KamarModel getKamarByNoKamar(Long noKamar);

    KamarModel changeKamar(Long noKamar, KamarModel kamarUpdate);

    void deleteKamar(Long noKamar);
}
