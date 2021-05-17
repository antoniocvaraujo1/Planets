package br.com.ame.planets.service;

import br.com.ame.planets.adpter.PlanetAdapter;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.response.ResultsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    private HttpClientService _httpClientService;

    @Autowired
    PlanetService _planetService;

    @Autowired
    PlanetAdapter _planetAdapter;

    @Value("${starwars.base.url}")
    public String apiBaseUrl;

    public Mono<Planet> findByName(String name) {

        var parameters = new HashMap<String, String>();
        parameters.put("search", name);

        ResultsResponse result = (ResultsResponse) _httpClientService.getRequest(apiBaseUrl + "planets/", parameters, ResultsResponse.class);

        if (result.count == 1) {
            Planet planet = _planetAdapter.convertToEntity(result.getResults().get(0));
            return _planetService.save(planet);
        }

        return null;
    }

}
