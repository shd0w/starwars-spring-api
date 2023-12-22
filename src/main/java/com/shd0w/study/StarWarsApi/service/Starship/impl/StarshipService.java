package com.shd0w.study.StarWarsApi.service.Starship.impl;

import com.shd0w.study.StarWarsApi.model.StarshipModel;
import com.shd0w.study.StarWarsApi.service.Starship.service.StarshipInterface;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

import static com.shd0w.study.StarWarsApi.utils.GetUri.getUri;

@Service
@Slf4j
public class StarshipService implements StarshipInterface {
    private static final URI endpointUri = URI.create("https://swapi.dev/api/starships");

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public StarshipModel getAllStarships(@Nullable Integer page, @Nullable String searchQuery) {
        URI uri = getUri(page, searchQuery, endpointUri, null);

        try {
            StarshipModel response = restTemplate.getForObject(uri.toString(), StarshipModel.class);
            log.info("Response All People: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }
    }

    @Override
    public StarshipModel getStarshipsById(@Nullable Integer id) {

        URI uri = getUri(null, null, endpointUri, id);

        try {
            StarshipModel response = restTemplate.getForObject(uri.toString(), StarshipModel.class);
            log.info("Response Film By ID: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }

    }
}
