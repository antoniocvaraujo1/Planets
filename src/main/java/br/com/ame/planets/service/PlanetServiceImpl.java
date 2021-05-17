package br.com.ame.planets.service;

import br.com.ame.planets.adpter.PlanetAdapter;
import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Override
    public Mono<Planet> save(PlanetDto planetDto) {

        Planet planet =_planetAdapter.convertToEntity(planetDto);
        return _planetRepository.save(planet);
    }

    @Override
    public Mono<Planet> save(Planet planet) {

        return _planetRepository.save(planet);
    }

    @Override
    public Mono<Planet> findByNome(String name) {

        Mono<Planet> planet;

        planet = _planetRepository.findByNome(name);

        if (!planet.blockOptional().isPresent()) {
            planet = _starwarsService.findByName(name);
        }

        return planet;
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
