package br.com.ame.planets.response;

import java.util.List;

public class ResultsResponse {
    public int count;
    public Object next;
    public Object previous;
    public List<PlanetResponse> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<PlanetResponse> getResults() {
        return results;
    }

    public void setResults(List<PlanetResponse> results) {
        this.results = results;
    }
}