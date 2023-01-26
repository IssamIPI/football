package com.example.football.controllers.admin;

import com.example.football.forms.MatchForm;
import com.example.football.pojos.*;
import com.example.football.repository.MatchRepository;
import com.example.football.services.JourneyService;
import com.example.football.services.LeagueService;
import com.example.football.services.MatchService;
import com.example.football.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        journey.addMatch(match);

        return "create";
    }
    @Autowired
    private MatchRepository matchRepository;

    @RequestMapping(value = "/match/ShowEdit", method = RequestMethod.GET)
    public String editmatchtable(Model model)
    {
        model.addAttribute("match", matchService.getAllMatches());
        return "admin/match/ShowEdit";
    }
    @RequestMapping(value = "/editMatch", method = RequestMethod.GET)
    public String editLeague(@RequestParam("id") Long id, Model model) {
        System.out.println(id);
        Match selectedMatch = matchService.getOneMatchById(id);

        model.addAttribute("match", selectedMatch);
        return "admin/match/edit";
    }


    @PostMapping("/updateMatch")
    public String updateLeague(@ModelAttribute("match") Match match, BindingResult bindingResult, Model model) {
        Optional<Match> matchDB = matchRepository.findById(match.getId());
        if(matchDB.isPresent()) {
            matchDB.get().setGoalsFromHomeTeam(match.getGoalsFromHomeTeam());
            matchDB.get().setGoalsFromAwayTeam(match.getGoalsFromAwayTeam());
            matchDB.get().setStadium(match.getStadium());
            matchDB.get().setJourney(match.getJourney());
            matchDB.get().setAwayTeam(match.getAwayTeam());
            matchDB.get().setHomeTeam(match.getHomeTeam());
            matchRepository.save(matchDB.get());
        }
        return "redirect:/leagues";
    }
}
