package br.com.ame.planets.adpter;

import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.response.PlanetResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PlanetAdapterImpl implements PlanetAdapter {

    @Override
    public Planet convertToEntity(PlanetResponse planetResponse) {

        Planet planet = new Planet(planetResponse.name,planetResponse.climate,planetResponse.terrain,planetResponse.films,planetResponse.films.size());

        return planet;
    }

    @Override
    public Planet convertToEntity(PlanetDto planetDto) {
        Planet planet = new Planet(planetDto.getNome(),planetDto.getClima(),planetDto.getTerreno());
        return planet;
    }

}
