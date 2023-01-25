package com.example.football.services;

import com.example.football.pojos.League;

public interface LeagueService {

    League getOneLeagueById(Long idLeague);

    Iterable<League> getAllLeagues();

    League addNewLeague(League league);
}
