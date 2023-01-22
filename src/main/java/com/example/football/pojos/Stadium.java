package com.example.football.pojos;

import jakarta.persistence.*;

@Entity
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String address;
    private Integer capacity;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "Stadium_team",
            joinColumns = @JoinColumn(name = "stadium_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Team team;

    public Stadium() {}

    public Stadium(
            String name,
            Team team,
            String address,
            Integer capacity
    ) {
        this.name = name;
        this.team = team;
        this.address = address;
        this.capacity = capacity;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
