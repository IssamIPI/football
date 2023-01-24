package com.example.football.pojos;

import javax.validation.constraints.NotBlank;

public class Login {

    @NotBlank(message = "L'identifiant est obligatoire")
    private String login;
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;

    public Login() {
    }

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
