package com.example.football.services.impl;

import com.example.football.pojos.Journey;
import com.example.football.pojos.Match;
import com.example.football.repository.MatchRepository;
import com.example.football.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Match addNewMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Iterable<Match> getMatchesFromJourney(Journey journey) {
        return matchRepository.findMatchesByJourney(journey);
    }
}
