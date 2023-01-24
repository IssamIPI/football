package com.example.football.services;

import com.example.football.pojos.User;

public interface UserService {

    User getUserFromLogin(String login);

    User addNewUser(User user);
}
