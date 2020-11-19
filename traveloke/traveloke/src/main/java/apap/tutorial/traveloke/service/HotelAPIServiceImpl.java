package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.repository.HotelDb;
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
public class HotelAPIServiceImpl implements HotelAPIService{
    private final WebClient webClient;

    @Autowired
    private HotelDb hotelDb;

    public HotelAPIServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .defaultHeader("x-rapidapi-key", "70d8e19a2dmsh93167701c40c24cp1daf9bjsna1c50bb7d781")
                .defaultHeader("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .defaultHeader("useQueryString", "true")
                .baseUrl(Setting.hotelAPIUrl).build();
    }

    @Override
    public Mono<String> findHotelByCity(String city) {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("query", city);
        data.add("locale", "en_us");
        return this.webClient.get().uri(uriBuilder -> uriBuilder.queryParams(data).build())
                .retrieve()
                .bodyToMono(String.class);
    }
}