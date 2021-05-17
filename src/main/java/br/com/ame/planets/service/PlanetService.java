package br.com.ame.planets.service;

import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetService {

    Mono<Planet> save(Planet planet);
    Mono<Planet> save(PlanetDto planetDto);
    Mono<Planet> findByNome(String nome);
    Flux<Planet> getAllPlanets();
    Mono<Planet> getPlanetById(String id);
    Mono<Planet> deletePlanet(String id);
}