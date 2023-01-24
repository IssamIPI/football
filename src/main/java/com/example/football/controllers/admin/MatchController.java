package com.example.football.controllers.admin;

import com.example.football.forms.MatchForm;
import com.example.football.pojos.Journey;
import com.example.football.pojos.League;
import com.example.football.pojos.Match;
import com.example.football.pojos.Team;
import com.example.football.services.JourneyService;
import com.example.football.services.LeagueService;
import com.example.football.services.MatchService;
import com.example.football.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class MatchController {

    private TeamService teamService;
    private LeagueService leagueService;
    private JourneyService journeyService;
    private MatchService matchService;

    public MatchController(
            TeamService teamService,
            LeagueService leagueService,
            JourneyService journeyService,
            MatchService matchService
    ) {
        this.teamService = teamService;
        this.leagueService = leagueService;
        this.journeyService = journeyService;
        this.matchService = matchService;
    }

    @RequestMapping(value = "/match/new", method = RequestMethod.GET)
    public String newMatchForm(Model model)
    {
        // Pour créer un match, il faut sélectionner 2 équipes parmis ceux enregistrés
        Iterable<Team> teams = teamService.getAllTeams();

        // Pour créer un match, il faudra ensuite lui attribuer un championnat parmis ceux existants
        Iterable<League> leagues = leagueService.getAllLeagues();

        Iterable<Journey> journeys = journeyService.getAllJourneys();

        model.addAttribute("teams", teams);
        model.addAttribute("journeys", journeys);
        model.addAttribute("leagues", leagues);

        return "admin/match/new";
    }

    @RequestMapping(value = "/newMatch", method = RequestMethod.POST)
    public String newMatchSubmit(
        Model model,
        @ModelAttribute MatchForm matchForm,
        BindingResult bindingResult
    ) {
        long homeTeamId = matchForm.getHomeTeamId();
        long awayTeamId = matchForm.getAwayTeamId();
        long journeyId = matchForm.getJourneyId();
        Team homeTeam = teamService.getOneTeamById(homeTeamId);
        Team awayTeam = teamService.getOneTeamById(awayTeamId);
        Journey journey = journeyService.getOneJourneyById(journeyId);

        Match match = new Match();
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setJourney(journey);
        match.setStadium(homeTeam.getStadium());
        matchService.addNewMatch(match);

        return "test";
    }
}
