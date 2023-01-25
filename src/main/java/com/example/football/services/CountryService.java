package com.example.football.services;

import com.example.football.pojos.Country;
import com.example.football.pojos.League;

public interface CountryService {
    Iterable<Country> getAllCountries();

     Country getOneCountryById(long id);
}
