package com.example.football.pojos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer number;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "journey_id")
    private Set<Match> matches = new LinkedHashSet<>();

    public Journey() {}

    public Journey(
            Integer number
    ) {
        this.number = number;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
