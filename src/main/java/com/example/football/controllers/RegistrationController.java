package com.example.football.controllers;

import com.example.football.pojos.User;
import com.example.football.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistrationController {
    private UserService userService;

    public RegistrationController(
            UserService userService
    ){
        this.userService = userService;
    }

    @GetMapping("register")
    public String registerForm(Model model, @ModelAttribute User user) {
        // ...
        return "register";
    }

    @PostMapping("register")
    public String registerSubmit(Model model,
                           @Validated @ModelAttribute User user,
                           BindingResult bindingResult) {

        // ajoute le membre dans la base de données
        if (!bindingResult.hasErrors()) {
            userService.addNewUser(user);

            // redirige sur la page d'acceuil
            return "redirect:/leagues";
        }

        return "register";
    }
}
