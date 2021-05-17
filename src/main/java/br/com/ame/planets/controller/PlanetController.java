package br.com.ame.planets.controller;

import br.com.ame.planets.dto.PlanetDto;
import br.com.ame.planets.entity.Planet;
import br.com.ame.planets.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/planets")
@RestController
public class PlanetController {

    @Autowired
    private PlanetService _planetService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Mono<Planet> createPlanet(@RequestBody PlanetDto planetDto) {
        try {
            var savePlanet = _planetService.save(planetDto);
            return savePlanet;
        } catch (Exception e) {
            throw e;
        }

    }

    @GetMapping("/")
    public Flux<Planet> getAllPlanets() {
        try {
            return _planetService.getAllPlanets();
        } catch (Exception e) {
            throw e;
        }

    }

    @GetMapping("/name")
    public Mono<ResponseEntity<Planet>> getPlanetByName(@RequestParam("name") String name) {

        try {

            Mono<Planet> planet = _planetService.findByNome(name);
            return planet.map(p -> ResponseEntity.ok(p)).defaultIfEmpty(ResponseEntity.notFound().build());

        } catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Planet>> getPlanetById(String id) {
        try {
            var planet = _planetService.getPlanetById(id);
            return planet.map(p -> ResponseEntity.ok(p)).defaultIfEmpty(ResponseEntity.notFound().build());
        } catch (Exception e) {
            throw e;
        }

    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePlanet(String id) {
        try {
            return _planetService.deletePlanet(id)
                    .map(r -> ResponseEntity.ok().<Void>build())
                    .defaultIfEmpty(ResponseEntity.notFound().build());
        } catch (Exception e) {
            throw e;
        }

    }

}

