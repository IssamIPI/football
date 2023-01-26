package com.example.football.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String adminCreate()
    {
        return "admin/create";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String adminModify()
    {
        return "admin/modify";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminHome()
    {
        return "admin/home";
    }
}
