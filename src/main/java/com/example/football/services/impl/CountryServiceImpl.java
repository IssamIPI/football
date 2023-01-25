package com.example.football.services.impl;

import com.example.football.pojos.Country;
import com.example.football.pojos.League;
import com.example.football.repository.CountryRepository;
import com.example.football.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getOneCountryById(long id) {
        return countryRepository.findCountryById(id);
    }
}
