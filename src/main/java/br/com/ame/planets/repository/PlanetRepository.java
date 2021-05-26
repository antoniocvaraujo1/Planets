package br.com.ame.planets.repository;

import br.com.ame.planets.entity.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Repository
public interface PlanetRepository extends ReactiveMongoRepository<Planet, String> {

   public Flux<Planet> findByNome(String nome);
}
