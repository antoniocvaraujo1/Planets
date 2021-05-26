package br.com.ame.planets.service;

import br.com.ame.planets.adpter.PlanetAdapter;
import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private StarWarsService _starwarsService;

    @Autowired
    private PlanetRepository _planetRepository;

    @Autowired
    private PlanetAdapter _planetAdapter;


    public Disposable parallelSave(Planet onNext) {
        return Flux.just(onNext)
                .parallel()
                .runOn(Schedulers.elastic())
                .flatMap(_planetRepository::save)
                .subscribe();
    }

    public Mono<Void> errorLog(Throwable e) {
        //application log
        return Mono.empty();
    }

    public Flux<Planet> emptyReturn(Throwable e) {
        return errorLog(e).thenMany(Mono.empty());
    }


    @Override
    public Flux<Planet> findByNome(String name) {

        return _planetRepository.findByNome(name)
                .onErrorResume(this::emptyReturn);

    }

    @Override
    public Flux<Planet> getAllPlanets() {
       var planets = _planetRepository.findAll();

       return planets;

    }

    public Mono<Planet> getPlanetById(String id){
        var getPlanet = _planetRepository.findById(id);
        return getPlanet;
    }

    @Override
    public Mono<Planet> deletePlanet(String id) {

        return _planetRepository.findById(id)
                .flatMap(existingPlanet -> _planetRepository.delete(existingPlanet)
                        .then(Mono.just(existingPlanet)));

    }


}
