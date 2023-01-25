package com.example.football.controllers.admin;

import com.example.football.forms.LeagueForm;
import com.example.football.forms.MatchForm;
import com.example.football.pojos.*;
import com.example.football.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.CountDownLatch;

@Controller
@RequestMapping("/admin")
public class LeagueController {
    private CountryService countryService;
    private LeagueService leagueService;

    public LeagueController(
            CountryService countryService,
            LeagueService leagueService
    ) {
        this.countryService = countryService;
        this.leagueService = leagueService;
    }

    @RequestMapping(value = "/league/new", method = RequestMethod.GET)
    public String newLeagueForm(Model model)
    {
        Iterable<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "admin/league/new";
    }

    @RequestMapping(value = "/newLeague", method = RequestMethod.POST)
    public String newLeagueSubmit(
        Model model,
        @ModelAttribute LeagueForm leagueForm,
        BindingResult bindingResult
    ) {
        long countryId = leagueForm.getCountryId();
        Country country = countryService.getOneCountryById(countryId);

        League league = new League();
        league.setName(leagueForm.getName());
        league.setStartDate(leagueForm.getStartDate());
        league.setEndDate(leagueForm.getEndDate());
        league.setVictoryPoints(leagueForm.getVictoryPoints());
        league.setDefeatPoints(leagueForm.getDefeatPoints());
        league.setTiePoints(leagueForm.getTiePoints());
        league.setCountry(country);

        leagueService.addNewLeague(league);

        return "admin/index";
    }
}
