package apap.tutorial.traveloke.service;

import reactor.core.publisher.Mono;

public interface HospitalRestService {
    Mono<String> findHospital(String city);
}
