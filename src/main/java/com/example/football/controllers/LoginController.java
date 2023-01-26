package com.example.football.controllers;

import com.example.football.pojos.Login;
import com.example.football.pojos.User;
import com.example.football.services.UserService;
import jakarta.servlet.http.HttpSession;
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
public class LoginController {
    private HttpSession httpSession;
    private UserService userService;

    public LoginController(
            UserService userService,
            HttpSession httpSession
    ) {
        this.httpSession = httpSession;
        this.userService = userService;
    }

    @GetMapping("login")
    public String loginForm(Model model, @ModelAttribute Login login) {
        return "login";
    }

    @PostMapping("login")
    public String loginSubmit(Model model,
                        @Validated @ModelAttribute Login login,
                        BindingResult bindingResult) {

        // récupère le membre
        if (!bindingResult.hasErrors()) {
            System.out.println(login.getLogin());
            User user = userService.getUserFromLogin(login.getLogin());
            // test si les mdp sont identique
            if (user.getPassword().equals(login.getPassword())) {
                // ajoute le user dans la session
                httpSession.setAttribute("user", user);

                // redirige sur la page d'acceuil
                return "redirect:/admin/";
            }
        }

        return "login";
    }

    @GetMapping("logout")
    public String logoutForm() {

        httpSession.invalidate();

        // redirige sur la page d'acceuil
        return "redirect:/front/league";
    }
}