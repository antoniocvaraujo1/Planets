package br.com.ame.planets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableReactiveMongoRepositories
@SpringBootApplication
public class PlanetsApplication {


    public static void main(String[] args) {
        SpringApplication.run(PlanetsApplication.class, args);
    }

}
