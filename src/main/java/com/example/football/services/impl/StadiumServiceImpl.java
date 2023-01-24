package com.example.football.services.impl;

import com.example.football.pojos.Stadium;
import com.example.football.repository.StadiumRepository;
import com.example.football.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumServiceImpl implements StadiumService {
    @Autowired
    private StadiumRepository stadiumRepository;

    @Override
    public void addNewStadium(Stadium stadium) {
        stadiumRepository.save(stadium);
    }

    @Override
    public Stadium getOneStadiumById(long id) {
        return stadiumRepository.findStadiumById(id);
    }

    @Override
    public Iterable<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }
}
