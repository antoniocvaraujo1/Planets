package br.com.ame.planets.adpter;

import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.response.PlanetResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PlanetAdapter {


    Planet convertToEntity(Flux<PlanetResponse> planetResponse);
    Planet convertToEntity(PlanetDto planetDto);
}
