package com.example.football.controllers.admin;

import com.example.football.forms.TeamForm;
import com.example.football.pojos.League;
import com.example.football.pojos.Stadium;
import com.example.football.pojos.Team;
import com.example.football.services.LeagueService;
import com.example.football.services.StadiumService;
import com.example.football.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class TeamController {

    private TeamService teamService;
    private StadiumService stadiumService;
    private LeagueService leagueService;

    public TeamController(
            TeamService teamService,
            StadiumService stadiumService,
            LeagueService leagueService
    ) {
        this.teamService = teamService;
        this.stadiumService = stadiumService;
        this.leagueService = leagueService;
    }

    @RequestMapping(value = "/team/new", method = RequestMethod.GET)
    public String newTeamForm(Model model)
    {
        Iterable<League> leagues = leagueService.getAllLeagues();
        Iterable<Stadium> stadiums = stadiumService.getAllStadiums();

        model.addAttribute("leagues", leagues);
        model.addAttribute("stadiums", stadiums);
        return "admin/team/new";
    }


    @RequestMapping(value = "/newTeam", method = RequestMethod.POST)
    public String newMatchSubmit(
            Model model,
            @ModelAttribute TeamForm teamForm,
            BindingResult bindingResult
    ) {
        long stadiumId = teamForm.getStadiumId();
        long leagueId = teamForm.getLeagueId();
        Stadium stadium = stadiumService.getOneStadiumById(stadiumId);
        League league = leagueService.getOneLeagueById(leagueId);

        Team team = new Team();
        team.setName(teamForm.getName());
        team.setCoach(teamForm.getCoach());
        team.setHeadquarter(teamForm.getHeadquarter());
        team.setPhoneNumber(teamForm.getPhoneNumber());
        team.setPresident(teamForm.getPresident());
        team.setWebsite(teamForm.getWebsite());
        team.setStadium(stadium);
        team.setLeague(league);
        teamService.addNewTeam(team);
        model.addAttribute("team", team);

        return "test";
    }
}
