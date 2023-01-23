package com.example.football.repository;

import com.example.football.pojos.League;
import com.example.football.pojos.Team;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Iterable<Team> findTeamsByLeague(League league);
}