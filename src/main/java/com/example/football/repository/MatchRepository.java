package com.example.football.repository;

import com.example.football.pojos.Journey;
import com.example.football.pojos.League;
import com.example.football.pojos.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Iterable<Match> findMatchesByJourney(Journey journey);
}