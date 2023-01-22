package com.example.football.pojos;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer goalsFromHomeTeam;
    private Integer goalsFromAwayTeam;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    public Match() {

    }

    public Match(
            Journey journey,
            Team homeTeam,
            Team awayTeam,
            Stadium stadium
    ) {
        this.journey = journey;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoalsFromHomeTeam() {
        return goalsFromHomeTeam;
    }

    public void setGoalsFromHomeTeam(Integer goalsFromHomeTeam) {
        this.goalsFromHomeTeam = goalsFromHomeTeam;
    }

    public Integer getGoalsFromAwayTeam() {
        return goalsFromAwayTeam;
    }

    public void setGoalsFromAwayTeam(Integer goalsFromAwayTeam) {
        this.goalsFromAwayTeam = goalsFromAwayTeam;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

}
