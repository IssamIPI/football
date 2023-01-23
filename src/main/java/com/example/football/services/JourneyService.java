package com.example.football.services;

import com.example.football.pojos.Journey;
import com.example.football.pojos.League;

public interface JourneyService {

    Iterable<Journey> getJourneysByLeague(League league);
}
