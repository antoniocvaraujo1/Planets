package br.com.ame.planets.service;

import br.com.ame.planets.adpter.PlanetAdapter;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.response.PlanetResponse;
import br.com.ame.planets.response.ResultsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    PlanetService _planetService;

    @Autowired
    PlanetAdapter _planetAdapter;

    private WebClient webClient;

    @Value("${starwars.base.url}")
    public String apiBaseUrl;

    @Value("${starwars.planet.url}")
    public String planetUrl;

    @PostConstruct
    private void init() {

        this.webClient = WebClient.create(apiBaseUrl);
    }


    public Flux<Planet> findByName(String name) {

        var parameters = new HashMap<String, String>();
        parameters.put("search", name);

        var result = webClient.get()
                .uri(builder -> builder.path(planetUrl).queryParam("search", name).build())
                .exchange()
                .flatMapMany(this::bodyToFlux);

        var fluxresult = result.map(ResultsResponse::getResults).flatMap(Flux::fromIterable);

            Planet planet = _planetAdapter.convertToEntity(fluxresult);

            _planetService.parallelSave(planet);

            Flux<Planet> planetFlux = Flux.just(planet);

        return planetFlux;
    }

    private Flux<ResultsResponse> bodyToFlux(ClientResponse a) {

        return a.bodyToFlux(ResultsResponse.class);
    }

}
