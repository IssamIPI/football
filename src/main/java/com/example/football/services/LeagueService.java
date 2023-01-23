package com.example.football.services;

import com.example.football.pojos.League;

import java.util.List;

public interface LeagueService {

    League getOneLeagueById(Long idLeague);

    Iterable<League> getAllLeagues();
}
