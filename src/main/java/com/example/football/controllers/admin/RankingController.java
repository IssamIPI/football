package com.example.football.controllers.admin;


import com.example.football.pojos.Country;
import com.example.football.pojos.League;
import com.example.football.pojos.User;
import com.example.football.repository.CountryRepository;
import com.example.football.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RankingController {
    @Autowired
    private LeagueRepository leagueRepository;


    @GetMapping("/createLeague")
    public String createLeagueForm(Model model) {

        model.addAttribute("league", new League());
        return "createLeague";
    }
    @GetMapping("/DeleteAllLeagues")
    public String deleteAllleagues() {
        leagueRepository.deleteAll();
        return "DeletedLeagues";
    }

    @PostMapping("/addedleague")
    public String saveLeague(@ModelAttribute League league,
                             BindingResult bindingResult) {
        Country tmp = new Country();
        tmp.setName(league.getCountry().getName());
        league.setCountry(tmp);
        System.out.println(league.getCountry().getName());
        if (bindingResult.hasErrors()) {
            return "createLeague";
        }
        countryRepository.save(tmp);
        leagueRepository.save(league);
        return "championnat";
    }

    @Autowired
    private CountryRepository countryRepository;



    @GetMapping("user")
    public String testSessionParam(Model model, @SessionAttribute User user) {

        model.addAttribute("user", user);

        return "user_detail";
    }

    @GetMapping("add_user")
    public String userForm(Model model, @ModelAttribute User user) {

        model.addAttribute("user", user);

        return "add_user";
    }

    @PostMapping("add_user")
    public String addUser(Model model, @Validated @ModelAttribute User user,
                          BindingResult bindingResult) {

        // réaffiche le formulaire car il y a des erreurs
        if (bindingResult.hasErrors()) {
            return "add_user";
        }

        model.addAttribute("user", user);

        return "user_detail";
    }
}
