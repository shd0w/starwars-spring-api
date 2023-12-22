package com.shd0w.study.StarWarsApi.service.Starship.service;

import com.shd0w.study.StarWarsApi.model.SpecieModel;
import com.shd0w.study.StarWarsApi.model.StarshipModel;
import jakarta.annotation.Nullable;

public interface StarshipInterface {


    StarshipModel getAllStarships(@Nullable Integer page, @Nullable String searchQuery);

    StarshipModel getStarshipsById(@Nullable Integer id);
}
