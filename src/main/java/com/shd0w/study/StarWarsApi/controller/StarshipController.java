package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.StarshipModel;
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
@RequestMapping("/api/starships")
public class StarshipController {

    private static final URI endpointUri = URI.create("https://swapi.dev/api/starships");
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<StarshipModel> getAllStarships(@RequestParam(required = false) Integer page, String searchQuery) {

        URI uri = getUri(page, searchQuery, endpointUri);

        try {
            ResponseEntity<StarshipModel> response = restTemplate.exchange(uri, HttpMethod.GET, null, StarshipModel.class);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipModel> getAllStarships(@PathVariable Integer id) {

        URI uri = getUri(null, null, endpointUri);

        try {
            ResponseEntity<StarshipModel> response = restTemplate.exchange(uri+"/"+id, HttpMethod.GET, null, StarshipModel.class);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
