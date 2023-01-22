package com.example.football.pojos;

import jakarta.persistence.*;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer homeTeamPoints;
    private Integer awayTeamPoints;
    @OneToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;
    @OneToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;
    @OneToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

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

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(Integer homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }

    public Integer getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(Integer awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }
}
