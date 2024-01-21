package com.profileprojects.leaderboard.services;

import com.profileprojects.leaderboard.entities.Game;
import com.profileprojects.leaderboard.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService extends BaseService<GameRepository, Game, Long> {

    @Autowired
    private GameRepository gameRepository;

}
