package com.example.football.pojos;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String lastname;
    @NotBlank(message = "Le prénom est obligatoire")
    private String firstname;
    @NotBlank(message = "Le login est obligatoire")
    private String login;
    @Size(min = 6, message = "Le mot de passe doit comptenir au moins 6 cractères")
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;
    @NotBlank(message = "Le pseudo est obligatoire")
    private String pseudo;

    public User(
            String firstname,
            String lastname,
            String login,
            String password,
            String pseudo
    ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.pseudo = pseudo;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + lastname + '\'' +
                ", prenom='" + firstname + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", identifiant='" + login + '\'' +
                '}';
    }
}
