package com.profileprojects.leaderboard.services;

import com.profileprojects.leaderboard.entities.User;
import com.profileprojects.leaderboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserRepository, User, Long> {

    @Autowired
    private UserRepository userRepository;
}
