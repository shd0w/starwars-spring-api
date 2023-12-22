package com.shd0w.study.StarWarsApi.service.Species.impl;

import com.shd0w.study.StarWarsApi.model.SpecieModel;
import com.shd0w.study.StarWarsApi.service.Species.interfaces.SpeciesInterface;
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
public class SpeciesService implements SpeciesInterface {
    private static final URI endpointUri = URI.create("https://swapi.dev/api/species");

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public SpecieModel getAllSpecies(@Nullable Integer page, @Nullable String searchQuery) {
        URI uri = getUri(page, searchQuery, endpointUri, null);

        try {
            SpecieModel response = restTemplate.getForObject(uri.toString(), SpecieModel.class);
            log.info("Response All People: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }
    }

    @Override
    public SpecieModel getSpeciesById(@Nullable Integer id) {

        URI uri = getUri(null, null, endpointUri, id);

        try {
            SpecieModel response = restTemplate.getForObject(uri.toString(), SpecieModel.class);
            log.info("Response Film By ID: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }

    }
}
