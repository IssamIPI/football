package com.example.football.repository;

import com.example.football.pojos.League;
import com.example.football.pojos.Team;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Iterable<Team> findTeamsByLeague(League league);

    Iterable<Team> findAllByLeague(Sort totalPoints, League league);
}