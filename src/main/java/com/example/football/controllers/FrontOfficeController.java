package com.example.football.controllers;

import com.example.football.pojos.*;
import com.example.football.repository.LeagueRepository;
import com.example.football.services.JourneyService;
import com.example.football.services.LeagueService;
import com.example.football.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class FrontOfficeController {

    private LeagueService leagueService;
    private TeamService teamService;
    private JourneyService journeyService;

    public FrontOfficeController(
            LeagueService leagueService,
            TeamService teamService,
            JourneyService journeyService
    ) {
        this.leagueService = leagueService;
        this.teamService = teamService;
        this.journeyService = journeyService;
    }

    @GetMapping(path = "/leagues")
    public String leaguesIndex(Model model)
    {
        // envoie les données à la vue
        model.addAttribute("allLeagues", leagueService.getAllLeagues());

        return "leagues";
    }

    @GetMapping(path = "/league")
    public String showLeague(Model model, @RequestParam long idLeague)
    {
        League selectedLeague = leagueService.getOneLeagueById(idLeague);
        Iterable<Journey> journeys = journeyService.getJourneysByLeague(selectedLeague);
        Iterable<Team> teams = teamService.getTeamsFromLeague(selectedLeague);

        model.addAttribute("league", selectedLeague);
        model.addAttribute("journeys", journeys);
        model.addAttribute("teams", teams);

        return "league";
    }
}
