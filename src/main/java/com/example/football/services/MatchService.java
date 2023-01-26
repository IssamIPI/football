package com.example.football.services;

import com.example.football.pojos.Journey;
import com.example.football.pojos.Match;

public interface MatchService {

    Match addNewMatch(Match match);
    Iterable<Match> getMatchesFromJourney(Journey journey);

    Iterable<Match> getAllMatches();
    Match getOneMatchById(Long idMatch);
}
