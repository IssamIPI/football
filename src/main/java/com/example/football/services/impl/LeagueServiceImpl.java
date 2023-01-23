package com.example.football.services.impl;

import com.example.football.pojos.League;
import com.example.football.repository.LeagueRepository;
import com.example.football.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    @Override
    public League getOneLeagueById(Long idLeague) {
        return leagueRepository.findById(idLeague).orElse(null);
    }

    @Override
    public Iterable<League> getAllLeagues() {
        return leagueRepository.findAll();
    }
}
