package com.example.football.controllers.admin;

import com.example.football.forms.MatchForm;
import com.example.football.pojos.*;
import com.example.football.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class StadiumController {
    private StadiumService stadiumService;

    public StadiumController(
        StadiumService stadiumService
    ) {
        this.stadiumService = stadiumService;
    }

    @RequestMapping(value = "/stadium/new", method = RequestMethod.GET)
    public String newStadiumForm(Model model)
    {
        return "admin/stadium/new";
    }

    @RequestMapping(value = "/newStadium", method = RequestMethod.POST)
    public String newMatchSubmit(
            Model model,
            @ModelAttribute Stadium stadium,
            BindingResult bindingResult
    ) {
        stadiumService.addNewStadium(stadium);
        model.addAttribute("stadium", stadium);

        return "admin/index";
    }
}
