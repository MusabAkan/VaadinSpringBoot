package com.musakan.core.service;

import com.musakan.core.dataAccess.CityRepository;
import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.City;
import com.musakan.core.service.base.BaseManager;
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
