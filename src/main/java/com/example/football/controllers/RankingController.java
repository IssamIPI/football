package com.example.football.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankingController {

    @GetMapping(path = "/ranking")
    public String rankingIndex()
    {
        return "ranking";
    }
}
