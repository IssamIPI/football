package com.example.football.pojos;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.*;

@Entity
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private Integer victoryPoints;
    private Integer defeatPoints;
    private Integer tiePoints;

    @OneToMany(targetEntity = Journey.class, mappedBy = "league")
    private List<Journey> journeys = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(mappedBy = "league")
    private Collection<Team> team;

    public League() {}

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(Integer victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public Integer getDefeatPoints() {
        return defeatPoints;
    }

    public void setDefeatPoints(Integer defeatPoints) {
        this.defeatPoints = defeatPoints;
    }

    public Integer getTiePoints() {
        return tiePoints;
    }

    public void setTiePoints(Integer tiePoints) {
        this.tiePoints = tiePoints;
    }

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public Collection<Team> getTeams() {
        return team;
    }

    public void setTeams(Collection<Team> team) {
        this.team = team;
    }
}
