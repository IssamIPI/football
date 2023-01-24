package com.example.football.services.impl;

import com.example.football.pojos.User;
import com.example.football.repository.UserRepository;
import com.example.football.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserFromLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }
}
