package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.SpecieModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

import static com.shd0w.study.StarWarsApi.utils.GetUri.getUri;

@ResponseBody
@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    private static final URI endpointUri = URI.create("https://swapi.dev/api/species");
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<SpecieModel> getAllSpecies(@RequestParam(required = false) Integer page, String searchQuery) {

        URI uri = getUri(page, searchQuery, endpointUri, null);

        try {
            ResponseEntity<SpecieModel> response = restTemplate.exchange(uri, HttpMethod.GET, null, SpecieModel.class);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecieModel> getSpeciesById(@PathVariable Integer id) {

        URI uri = getUri(null, null, endpointUri, id);

        try {
            ResponseEntity<SpecieModel> response = restTemplate.exchange(uri, HttpMethod.GET, null, SpecieModel.class);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
