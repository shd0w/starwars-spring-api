package com.shd0w.study.StarWarsApi.service.Vehicle.impl;

import com.shd0w.study.StarWarsApi.model.VehicleModel;
import com.shd0w.study.StarWarsApi.service.Vehicle.interfaces.VehicleInterface;
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
public class VehicleService implements VehicleInterface {
    private static final URI endpointUri = URI.create("https://swapi.dev/api/vehicles");

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public VehicleModel getAllVehicle(@Nullable Integer page, @Nullable String searchQuery) {
        URI uri = getUri(page, searchQuery, endpointUri, null);

        try {
            VehicleModel response = restTemplate.getForObject(uri.toString(), VehicleModel.class);
            log.info("Response All People: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }
    }

    @Override
    public VehicleModel getVehicleById(@Nullable Integer id) {

        URI uri = getUri(null, null, endpointUri, id);

        try {
            VehicleModel response = restTemplate.getForObject(uri.toString(), VehicleModel.class);
            log.info("Response Film By ID: " + response);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum registro encontrado");
        }

    }
}
