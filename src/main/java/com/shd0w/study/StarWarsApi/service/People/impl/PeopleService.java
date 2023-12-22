package com.shd0w.study.StarWarsApi.service.People.impl;

import com.shd0w.study.StarWarsApi.model.PeopleModel;
import com.shd0w.study.StarWarsApi.service.People.interfaces.PeopleInterface;
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
public class PeopleService implements PeopleInterface {
    private static final URI endpointUri = URI.create("https://swapi.dev/api/people");

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public PeopleModel getAllPeople(@Nullable Integer page, @Nullable String searchQuery) {
        URI uri = getUri(page, searchQuery, endpointUri, null);

        try {
            PeopleModel response = restTemplate.getForObject(uri.toString(), PeopleModel.class);
            log.info("Response All People: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }
    }

    @Override
    public PeopleModel getPeopleById(@Nullable Integer id) {

        URI uri = getUri(null, null, endpointUri, id);

        try {
            PeopleModel response = restTemplate.getForObject(uri.toString(), PeopleModel.class);
            log.info("Response Film By ID: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }

    }
}
