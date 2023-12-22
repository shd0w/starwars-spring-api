package com.shd0w.study.StarWarsApi.service.impl;

import com.shd0w.study.StarWarsApi.model.FilmModel;
import com.shd0w.study.StarWarsApi.service.interfaces.FilmInterface;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

import static com.shd0w.study.StarWarsApi.utils.GetUri.getUri;

@Service
@Slf4j
public class FilmService implements FilmInterface {
    private static final URI endpointUri = URI.create("https://swapi.dev/api/films");

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public FilmModel getAllFilms(@Nullable Integer page, @Nullable String searchQuery) {
        URI uri = getUri(page, searchQuery, endpointUri, null);

        try {
            FilmModel response = restTemplate.getForObject(uri.toString(), FilmModel.class);
            log.info("Response All Films: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }
    }

    @Override
    public FilmModel getFilmById(@Nullable Integer id) {

        URI uri = getUri(null, null, endpointUri, id);

        try {
            FilmModel response = restTemplate.getForObject(uri.toString(), FilmModel.class);
            log.info("Response Film By ID: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }

    }
}
