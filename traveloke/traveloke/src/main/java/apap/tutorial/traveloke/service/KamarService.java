package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel findKamarByNomorKamar(Long noKamar);

    KamarModel updateKamar(KamarModel kamar);

    void deleteKamar(KamarModel kamar);
}
