package com.example.football.services;

import com.example.football.pojos.Journey;
import com.example.football.pojos.League;

public interface JourneyService {

    Journey getOneJourneyById(Long id);
    Iterable<Journey> getAllJourneys();
    Iterable<Journey> getJourneysByLeague(League league);
}
