package com.example.football.services;

import com.example.football.pojos.Stadium;
import com.example.football.pojos.Team;

public interface StadiumService {

    void addNewStadium(Stadium stadium);

    Stadium getOneStadiumById(long id);

    Iterable<Stadium> getAllStadiums();
}
