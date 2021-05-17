package br.com.ame.planets.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "planets")
public class Planet {

    @Id
    private String id;
    private String nome;
    private String clima;
    private String terreno;
    private List<String> films;
    private Integer aparicoes;

    public Planet() {
    }

    public Planet(String nome, String clima, String terreno) {
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
    }

    public Planet(String nome, String clima, String terreno, List<String> films, Integer aparicoes) {
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
        this.films = films;
        this.aparicoes = aparicoes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public Integer getAparicoes() {
        return aparicoes;
    }

    public void setAparicoes(Integer aparicoes) {
        this.aparicoes = aparicoes;
    }

}

