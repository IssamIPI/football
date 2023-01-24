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
    @GetMapping(path = "/leagues")
    public String leaguesIndex(Model model)
    {
        // envoie les données à la vue
        model.addAttribute("allLeagues", leagueService.getAllLeagues());

        return "front/leagues";
    }

//    Afficher un championnat + journées du champ. + matchs par journée + équipes par match + un bouton pour accéder au classement du champ.
    @GetMapping(path = "/league")
    public String showLeague(Model model, @RequestParam long idLeague)
    {
        League selectedLeague = leagueService.getOneLeagueById(idLeague);
        Iterable<Journey> journeys = journeyService.getJourneysByLeague(selectedLeague);
        Iterable<Team> teams = teamService.getTeamsFromLeague(selectedLeague);

        model.addAttribute("league", selectedLeague);
        model.addAttribute("journeys", journeys);
        model.addAttribute("teams", teams);

        return "front/league";
    }

    //    Afficher les détails d'une équipe sélectionné
    @GetMapping(path = "/team")
    public String showTeamFromLeague(Model model, @RequestParam long idLeague, @RequestParam long idTeam)
    {
        League selectedLeague = leagueService.getOneLeagueById(idLeague);
        Team selectedTeam = teamService.getOneTeamById(idTeam);

        model.addAttribute("league", selectedLeague);
        model.addAttribute("team", selectedTeam);

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
