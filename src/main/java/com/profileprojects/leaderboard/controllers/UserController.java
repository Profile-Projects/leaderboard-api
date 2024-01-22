package com.profileprojects.leaderboard.controllers;

import com.profileprojects.leaderboard.entities.Game;
import com.profileprojects.leaderboard.entities.User;
import com.profileprojects.leaderboard.repositories.UserRepository;
import com.profileprojects.leaderboard.requests.CreateUserRequest;
import com.profileprojects.leaderboard.services.GameService;
import com.profileprojects.leaderboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController<UserService, User, Long, UserRepository> {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody CreateUserRequest createUserRequest) {
        final var gameId = createUserRequest.getGameId();
        final Optional<Game> gameO = gameService.get(gameId);
        if (gameO.isEmpty()) return ResponseEntity.notFound().build();
        return super.add(createUserRequest.toUser());
    }
}
