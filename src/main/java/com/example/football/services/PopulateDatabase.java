package com.example.football.services;

import com.example.football.repository.LeagueRepository;
import org.springframework.stereotype.Service;

@Service
public class PopulateDatabase {

    private final LeagueRepository leagueRepository;
    public PopulateDatabase(LeagueRepository leagueRepository){
        this.leagueRepository = leagueRepository;
    }

}
