package com.profileprojects.leaderboard.controllers;

import com.profileprojects.leaderboard.entities.Game;
import com.profileprojects.leaderboard.repositories.GameRepository;
import com.profileprojects.leaderboard.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@CrossOrigin
public class GameController extends BaseController<GameService, Game, Long, GameRepository> {

    @Autowired
    private GameService gameService;
}
