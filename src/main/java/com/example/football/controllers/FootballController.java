//package com.example.football.controllers;
//
//import com.example.football.pojos.*;
//import com.example.football.repository.*;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Controller;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//public class FootballController {
//
//    private CountryRepository countryRepository;
//    private LeagueRepository leagueRepository;
//    private JourneyRepository journeyRepository;
//    private MatchRepository matchRepository;
//    private TeamRepository teamRepository;
//    private StadiumRepository stadiumRepository;
//    private UserRepository userRepository;
//    public FootballController(
//        CountryRepository countryRepository,
//        LeagueRepository leagueRepository,
//        JourneyRepository journeyRepository,
//        MatchRepository matchRepository,
//        TeamRepository teamRepository,
//        StadiumRepository stadiumRepository,
//        UserRepository userRepository
//    ) {
//        super();
//         this.countryRepository = countryRepository;
//         this.leagueRepository = leagueRepository;
//         this.journeyRepository = journeyRepository;
//         this.matchRepository = matchRepository;
//         this.teamRepository = teamRepository;
//         this.stadiumRepository = stadiumRepository;
//         this.userRepository = userRepository;
//    }
//
//    @PostConstruct
//    private void init() {
//
//        // Créer 2 utilisateurs
//        User Kevin = new User("Kevin", "Vong", "kevin.vong@gmail.com", "kevinvong", "kevkev");
//        User Issam = new User("Issam", "Allouani", "issam.allouani@gmail.com", "issamall", "ississ");
//        userRepository.save(Kevin);
//        userRepository.save(Issam);
//
//        // Créer un pays
//        Country france = new Country();
//        france.setName("France");
//        countryRepository.save(france);
//
//        // Créer 2 ligues
//        League league1 = new League();
//        league1.setName("Ligues de champions");
//        league1.setVictoryPoints(5);
//        league1.setDefeatPoints(3);
//        league1.setTiePoints(0);
//        league1.setCountry(france);
//        league1.setStartDate(new Date(2022, 9, 1));
//        league1.setEndDate(new Date(2023, 6, 30));
//
//        League league2 = new League();
//        league2.setName("Ligues de loosers");
//        league2.setVictoryPoints(5);
//        league2.setDefeatPoints(3);
//        league2.setTiePoints(0);
//        league2.setCountry(france);
//        league2.setStartDate(new Date(2023, 9, 1));
//        league2.setEndDate(new Date(2024, 6, 30));
//
//
//        // Créer 4 journées
//        Journey journey1 = new Journey(15, league1);
//        Journey journey2 = new Journey(16, league1);
//        Journey journey3 = new Journey(17, league1);
//
//        leagueRepository.save(league1);
//        leagueRepository.save(league2);
//
//        journeyRepository.save(journey1);
//        journeyRepository.save(journey2);
//        journeyRepository.save(journey3);
//
//        // Créer 4 stades
//        Stadium stadium1 = new Stadium("Parc des princes",  "Paris, FRA", 48000);
//        Stadium stadium2 = new Stadium("Camp Nou", "Barcelone, ESP", 99000);
//        Stadium stadium3 = new Stadium("Santiago Bernabeu", "Madrid, ESP", 81000);
//        Stadium stadium4 = new Stadium("Etihad Stadium", "Manchester, ENG", 53400);
//        stadiumRepository.save(stadium1);
//        stadiumRepository.save(stadium2);
//        stadiumRepository.save(stadium3);
//        stadiumRepository.save(stadium4);
//
//        // Créer 4 équipes
//        Team psg = new Team(league1, stadium1, "Paris Saint Germain", "Michael A. Jordan", "Nasser Al Khelaïfi",  "Paris 75000", 698653210, "psg.com");
//        Team barcelone = new Team(league1, stadium2, "Barcelone", "Michael B. Jordan", "Khalid Al Khelaïfi",  "Paris 75000", 698653211, "barca.com");
//        Team realmadrid = new Team(league1, stadium3, "Real Madrid", "Michael C. Jordan", "Yousef Al Khelaïfi",  "Paris 75000", 698653212, "realm.com");
//        Team mancity = new Team(league1, stadium4, "Manchester City", "Michael D. Jordan", "Mounir Al Khelaïfi", "Paris 75000", 698653213, "mc.com");
//        teamRepository.save(psg);
//        teamRepository.save(realmadrid);
//        teamRepository.save(barcelone);
//        teamRepository.save(mancity);
//
//        // Créer 6 matches
//        Match match1 = new Match(journey1, psg, barcelone, stadium1);
//        Match match2 = new Match(journey1, realmadrid, mancity, stadium2);
//        Match match3 = new Match(journey2, barcelone, realmadrid, stadium3);
//        Match match4 = new Match(journey2, mancity, psg, stadium4);
//        Match match5 = new Match(journey3, psg, realmadrid, stadium1);
//        Match match6 = new Match(journey3, barcelone, mancity, stadium4);
//
//            matchRepository.save(match1);
//            matchRepository.save(match2);
//            matchRepository.save(match3);
//            matchRepository.save(match4);
//            matchRepository.save(match5);
//            matchRepository.save(match6);
//        }
//
//        // Set all the missings relations :
////        psg.setStadium(stadium1);
////        psg.setLeague(league1);
////        List<Match> psgMatches = new ArrayList<>();
////        psgMatches.add(match1);
////        psgMatches.add(match4);
////        psgMatches.add(match5);
////        psg.setMatches(psgMatches);
////
////        barcelone.setStadium(stadium2);
////        barcelone.setLeague(league1);
////        List<Match> barceloneMatches = new ArrayList<>();
////        barceloneMatches.add(match1);
////        barceloneMatches.add(match3);
////        barceloneMatches.add(match6);
////        barcelone.setMatches(barceloneMatches);
////
////        realmadrid.setStadium(stadium3);
////        realmadrid.setLeague(league1);
////        List<Match> realmadridMatches = new ArrayList<>();
////        realmadridMatches.add(match2);
////        realmadridMatches.add(match3);
////        realmadridMatches.add(match5);
////        realmadrid.setMatches(realmadridMatches);
////
////        mancity.setStadium(stadium4);
////        mancity.setLeague(league1);
////        List<Match> mancityMatches = new ArrayList<>();
////        mancityMatches.add(match2);
////        mancityMatches.add(match4);
////        mancityMatches.add(match6);
////        mancity.setMatches(mancityMatches);
//
//
////        List<Journey> league1Journeys = new ArrayList<>();
////        league1Journeys.add(journey1);
////        league1Journeys.add(journey2);
////        league1Journeys.add(journey3);
////
////        List<Team> league1Teams = new ArrayList<>();
////        league1Teams.add(psg);
////        league1Teams.add(barcelone);
////        league1Teams.add(realmadrid);
////        league1Teams.add(mancity);
////
////        league1.setJourneys(league1Journeys);
////        league1.setTeams(league1Teams);
//}
