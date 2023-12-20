package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.PlanetModel;
import com.shd0w.study.StarWarsApi.model.StarshipModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/planets")
@Tag(name="Planets", description = "SWAPI Planets Endpoint")
@Slf4j
public class PlanetsController {

    private static final URI endpointUri = URI.create("https://swapi.dev/api/planets");
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<PlanetModel> getAllPlanets(@RequestParam(required = false) Integer page, String searchQuery) {

        URI uri = getUri(page, searchQuery, endpointUri, null);

        try {
            ResponseEntity<PlanetModel> response = restTemplate.exchange(uri, HttpMethod.GET, null, PlanetModel.class);
            log.info("Response: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetModel> getPlanetById(@PathVariable Integer id) {

        URI uri = getUri(null, null, endpointUri, id);

        try {
            ResponseEntity<PlanetModel> response = restTemplate.exchange(uri, HttpMethod.GET, null, PlanetModel.class);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
