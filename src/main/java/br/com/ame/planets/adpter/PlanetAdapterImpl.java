package br.com.ame.planets.adpter;

import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.response.PlanetResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PlanetAdapterImpl implements PlanetAdapter {

    @Override
    public Planet convertToEntity(PlanetDto planetDto) {
        Planet planet = new Planet(planetDto.getNome(),planetDto.getClima(),planetDto.getTerreno());
        return planet;
    }

   public Planet convertToEntity(Flux<PlanetResponse> planetResponse){
       return null;
    }
}
