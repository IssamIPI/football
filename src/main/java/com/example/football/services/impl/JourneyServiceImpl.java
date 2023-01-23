package com.example.football.services.impl;

import com.example.football.pojos.*;
import com.example.football.repository.JourneyRepository;
import com.example.football.services.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    @Override
    public Iterable<Journey> getJourneysByLeague(League league) {
        return journeyRepository.findJourneysByLeague(league);
    }
}
