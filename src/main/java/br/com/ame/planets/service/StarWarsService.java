package br.com.ame.planets.service;

import br.com.ame.planets.entity.Planet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StarWarsService {

  Flux<Planet> findByName(String name);
}
