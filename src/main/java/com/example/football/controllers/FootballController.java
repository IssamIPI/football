package com.example.football.controllers;

import com.example.football.pojos.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

import java.util.Calendar;
import java.util.Date;

@Controller
public class FootballController {

    @PostConstruct
    private void init() {

    // Créer un pays
    Country france = new Country();
    country.setName("France");

    // Créer 2 ligues
    League league1 = new League();
    league1.setName("Ligues de champions");
    league1.setVictoryPoints(5);
    league1.setDefeatPoints(3);
    league1.setTiePoints(0);
    league1.setCountry(france);
    league1.setStartDate(new Date(2022, Calendar.SEPTEMBER, 1));
    league1.setEndDate(new Date(2023, Calendar.JUNE, 30));

    League league2 = new League();
    league2.setName("Ligues de loosers");
    league2.setVictoryPoints(5);
    league2.setDefeatPoints(3);
    league2.setTiePoints(0);
    league2.setCountry(france);
    league2.setStartDate(new Date(2023, Calendar.SEPTEMBER, 1));
    league2.setEndDate(new Date(2024, Calendar.JUNE, 30));

    // Créer 4 équipes
    Team psg = new Team("Paris Saint Germain", "Michael A. Jordan", "Nasser Al Khelaïfi",  "Paris 75000", 698653210, "psg.com");
    Team barcelone = new Team("Barcelone", "Michael B. Jordan", "Khalid Al Khelaïfi",  "Paris 75000", 698653211, "barca.com");
    Team realmadrid = new Team("Real Madrid", "Michael C. Jordan", "Yousef Al Khelaïfi",  "Paris 75000", 698653212, "realm.com");
    Team mancity = new Team("Manchester City", "Michael D. Jordan", "Mounir Al Khelaïfi", "Paris 75000", 698653213, "mc.com");

    // Créer 4 journées
    Journey journey1 = new Journey(15);
    Journey journey2 = new Journey(16);
    Journey journey3 = new Journey(17);
    Journey journey4 = new Journey(18);

    // Créer 4 stades
    Stadium stadium1 = new Stadium("Parc des princes", psg, "Paris, FRA", 48000);
    Stadium stadium2 = new Stadium("Camp Nou", barcelone, "Barcelone, ESP", 99000);
    Stadium stadium3 = new Stadium("Santiago Bernabeu",  realmadrid, "Madrid, ESP", 81000);
    Stadium stadium4 = new Stadium("Etihad Stadium", mancity, "Manchester, ENG", 53400);

    // Créer 8 matches
    Match match1 = new Match();
    Match match2 = new Match();
    Match match3 = new Match();
    Match match4 = new Match();
    Match match5 = new Match();
    Match match6 = new Match();
    Match match7 = new Match();
    Match match8 = new Match();


    // Créer 1 utilisateur
    }
}
