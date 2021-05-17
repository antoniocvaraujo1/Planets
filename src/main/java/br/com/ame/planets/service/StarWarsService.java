package br.com.ame.planets.service;

import br.com.ame.planets.entity.Planet;
import reactor.core.publisher.Mono;

public interface StarWarsService {

  Mono<Planet> findByName(String name);
}
