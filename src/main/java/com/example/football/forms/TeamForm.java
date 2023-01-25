package com.example.football.forms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TeamForm {
    @Id
    @Column(name = "id")
    private Long id;

    private String name;
    private String coach;
    private String headquarter;
    private Integer phoneNumber;
    private String president;
    private String website;
    private Integer leagueId;
    private Integer stadiumId;

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

    public String getHeadquarter() {
        return headquarter;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getPresident() {
        return president;
    }

    public String getWebsite() {
        return website;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public Integer getStadiumId() {
        return stadiumId;
    }
}
