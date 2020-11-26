package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class HospitalRestServiceImpl implements HospitalRestService{
    public final WebClient webClient;

    public HospitalRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.hospitalUrl).build();
    }

    @Override
    public Mono<String> findHospital(String city){
        return this.webClient.get().uri("http://www.communitybenefitinsight.org/api/get_hospitals.php?state="+ city)
                .retrieve().bodyToMono(String.class);
    }
}
