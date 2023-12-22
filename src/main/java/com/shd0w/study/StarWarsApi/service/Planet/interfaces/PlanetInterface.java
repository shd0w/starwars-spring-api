package com.shd0w.study.StarWarsApi.service.Planet.interfaces;

import com.shd0w.study.StarWarsApi.model.PlanetModel;
import jakarta.annotation.Nullable;

public interface PlanetInterface {
    PlanetModel getAllPlanets(@Nullable Integer page, @Nullable String searchQuery);

    PlanetModel getPlanetById(@Nullable Integer id);
}
