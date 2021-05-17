package br.com.ame.planets.service;

import javax.ws.rs.client.*;
import java.util.Map;

public interface HttpClientService<T> {

    Client getClient();

    T getRequest(String url, Map<String, String> parameters, Class<T> type);
}
