package com.mohmo.Pokemon.adapter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

@Component
public class PokemonRestClient {
    private final RestTemplate restTemplate;

    public PokemonRestClient(@Qualifier("pokemonRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public <T> T pokemonAPI(String url, Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        var response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(null, httpHeaders), responseType);
        return response.getBody();
    }
}
