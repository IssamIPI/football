package com.example.football.pojos;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public Country() {}

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

    @OneToMany(mappedBy = "country")
    private Collection<League> leagues;

    public Collection<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(Collection<League> leagues) {
        this.leagues = leagues;
    }
}
