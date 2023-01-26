package com.example.football.controllers.admin;

import com.example.football.forms.LeagueForm;
import com.example.football.pojos.Country;
import com.example.football.pojos.League;
import com.example.football.repository.LeagueRepository;
import com.example.football.services.CountryService;
import com.example.football.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @Autowired
    private LeagueRepository leagueRepository;

    @RequestMapping(value = "/league/ShowEdit", method = RequestMethod.GET)
    public String editLeaguetable(Model model)
    {
        model.addAttribute("leagues", leagueService.getAllLeagues());
        return "admin/league/ShowEdit";
    }
    @RequestMapping(value = "/editLeague", method = RequestMethod.GET)
    public String editLeague(@RequestParam("id") Long id, Model model) {
        System.out.println(id);
        League selectedLeague = leagueService.getOneLeagueById(id);

        model.addAttribute("league", selectedLeague);
        System.out.println(selectedLeague.getName());
        Iterable<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "admin/league/edit";
    }


    @PostMapping("/updateLeague")
    public String updateLeague(@ModelAttribute("league") League league, BindingResult bindingResult, Model model) {
        Optional<League> leagueDB = leagueRepository.findById(league.getId());
        if(leagueDB.isPresent()) {
            leagueDB.get().setName(league.getName());
            leagueDB.get().setStartDate(league.getStartDate());
            leagueDB.get().setEndDate(league.getEndDate());
            leagueDB.get().setTiePoints(league.getTiePoints());
            leagueDB.get().setVictoryPoints(league.getVictoryPoints());

            leagueRepository.save(leagueDB.get());
        }
        return "redirect:/leagues";
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

        return "create";
    }
}
