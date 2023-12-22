package com.shd0w.study.StarWarsApi.service.interfaces;

import com.shd0w.study.StarWarsApi.model.FilmModel;
import jakarta.annotation.Nullable;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface FilmInterface {
    FilmModel getAllFilms(@Nullable Integer page, @Nullable String searchQuery);

    FilmModel getFilmById(@Nullable Integer id);
}
