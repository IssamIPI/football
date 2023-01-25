package com.example.football.controllers;

import com.example.football.pojos.*;
import com.example.football.services.JourneyService;
import com.example.football.services.LeagueService;
import com.example.football.services.MatchService;
import com.example.football.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FrontController {

    private LeagueService leagueService;
    private TeamService teamService;
    private JourneyService journeyService;
    private MatchService matchService;


    public FrontController(
            LeagueService leagueService,
            TeamService teamService,
            JourneyService journeyService,
            MatchService matchService
    ) {
        this.leagueService = leagueService;
        this.teamService = teamService;
        this.journeyService = journeyService;
        this.matchService = matchService;
    }

//    Afficher tout les championnats
    @GetMapping(path = {"/", "/leagues"})
    public String leaguesIndex(Model model)
    {
        model.addAttribute("allLeagues", leagueService.getAllLeagues());
        model.addAttribute("teams", teamService.getAllTeams());

        return "front/leagues";
    }

//    Afficher un championnat + journées du champ. + matchs par journée + équipes par match + un bouton pour accéder au classement du champ.
    @GetMapping(path = "/league")
    public String showLeague(Model model, @RequestParam long idLeague)
    {
        League selectedLeague = leagueService.getOneLeagueById(idLeague);

        model.addAttribute("league", selectedLeague);
        model.addAttribute("journeys", journeyService.getJourneysByLeague(selectedLeague));

        model.addAttribute("teams", teamService.getAllTeamsRankedByLeague(selectedLeague));

        return "front/league";
    }

    //    Afficher les détails d'une équipe sélectionné
    @GetMapping(path = "/team")
    public String showTeamFromLeague(Model model, @RequestParam long idTeam)
    {
        model.addAttribute("team", teamService.getOneTeamById(idTeam));

        return "front/team";
    }

    //    Afficher le classement des équipes pour chaque champ.
    @GetMapping(path = "/ranking")
    public String rankingIndex(Model model)
    {
        Iterable<Team> teams = teamService.getAllTeams();

        model.addAttribute("teams", teams);

        return "front/ranking";
    }
}
