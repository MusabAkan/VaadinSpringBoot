package com.musakan.core.services;

import com.musakan.core.repositories.CityRepository;
import com.musakan.core.repositories.base.BaseRepository;
import com.musakan.core.entities.City;
import com.musakan.core.services.base.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager extends BaseManager<City> implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityManager(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    protected BaseRepository<City> getRepository() {
        return cityRepository;
    }
}
