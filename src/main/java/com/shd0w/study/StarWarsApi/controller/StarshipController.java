package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.StarshipModel;
import com.shd0w.study.StarWarsApi.service.Starship.impl.StarshipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/api/starships")
@Tag(name = "Starships", description = "SWAPI Starships Endpoint")
public class StarshipController {

    @Autowired
    StarshipService starshipService;

    @GetMapping
    public ResponseEntity<StarshipModel> getAllStarships(@RequestParam(required = false) Integer page, String searchQuery) {

        return ResponseEntity.ok(starshipService.getAllStarships(page, searchQuery));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipModel> getStarshipById(@PathVariable Integer id) {

        return ResponseEntity.ok(starshipService.getStarshipsById(id));

    }

}
