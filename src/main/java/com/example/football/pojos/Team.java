package com.example.football.pojos;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String coach;
    private String president;
    private String headquarter;
    private Integer phoneNumber;
    private String website;
    @OneToOne
    private Stadium stadium;
    @ManyToOne
    private League league;

    @ManyToMany
    private Collection<Match> matches;

    public Team() {}

    public Team(
            League league,
            Stadium stadium,
            String name,
            String coach,
            String president,
            String headquarter,
            Integer phoneNumber,
            String website
    ) {
        this.league = league;
        this.stadium = stadium;
        this.name = name;
        this.coach = coach;
        this.president = president;
        this.headquarter = headquarter;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Collection<Match> getMatches() {
        return matches;
    }

    public void setMatches(Collection<Match> matches) {
        this.matches = matches;
    }

    public void addMatch(Match match) {
        this.matches.add(match);
    }
}
