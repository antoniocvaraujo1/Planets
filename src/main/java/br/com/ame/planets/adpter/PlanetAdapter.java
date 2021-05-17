package br.com.ame.planets.adpter;

import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.response.PlanetResponse;
import reactor.core.publisher.Mono;

public interface PlanetAdapter {

    Planet convertToEntity(PlanetResponse planetResponse);
    Planet convertToEntity(PlanetDto planetDto);
}
