package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.FilmModel;
import com.shd0w.study.StarWarsApi.service.impl.FilmService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/api/films")
@Tag(name = "Films", description = "SWAPI Films Endpoint")
@Slf4j
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping
    public ResponseEntity<FilmModel> getAllFilms(@RequestParam(required = false) Integer page, @RequestParam(required = false) String searchQuery) {
        return ResponseEntity.ok(filmService.getAllFilms(page, searchQuery));

    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmModel> getFilmsById(@PathVariable Integer id) {
        return ResponseEntity.ok(filmService.getFilmById(id));

    }

}
