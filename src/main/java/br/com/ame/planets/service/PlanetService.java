package br.com.ame.planets.service;

import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetService {

    Disposable parallelSave(Planet onNext);
    Flux<Planet> findByNome(String nome);
    Flux<Planet> getAllPlanets();
    Mono<Planet> getPlanetById(String id);
    Mono<Planet> deletePlanet(String id);
    Flux<Planet> emptyReturn(Throwable e);
    Mono<Void> errorLog(Throwable e);

}