package com.musakan.core.service;

import com.musakan.core.dataAccess.CountryRepository;
import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.Country;
import com.musakan.core.service.base.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryManager extends BaseManager<Country> implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryManager(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    protected BaseRepository<Country> getRepository() {
        return countryRepository;
    }
}
