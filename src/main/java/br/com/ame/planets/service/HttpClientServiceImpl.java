package br.com.ame.planets.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Map;


@Service
public class HttpClientServiceImpl<T> implements HttpClientService<T> {

    @Override
    public Client getClient() {
        Client client = ClientBuilder.newClient();
        return client;
    }


    @Override
    public T getRequest(String url, Map<String, String> parameters, Class<T> type) {

        var httpClient = getClient();
        WebTarget webTarget = httpClient.target(url);

        if (!parameters.isEmpty()) {

            for (Map.Entry<String, String> param : parameters.entrySet()) {
                webTarget = webTarget.queryParam(param.getKey(), param.getValue());
            }
        }

        Invocation.Builder invocationBuilder = webTarget.request().accept(MediaType.APPLICATION_JSON);
        Object response = invocationBuilder.get().readEntity(type);

        return (T) response;
    }

}
