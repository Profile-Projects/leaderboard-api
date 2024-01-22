package com.profileprojects.leaderboard.controllers;

import com.profileprojects.leaderboard.entities.Game;
import com.profileprojects.leaderboard.entities.Score;
import com.profileprojects.leaderboard.entities.User;
import com.profileprojects.leaderboard.repositories.ScoreRepository;
import com.profileprojects.leaderboard.requests.CreateOrUpdateScoreRequest;
import com.profileprojects.leaderboard.services.GameService;
import com.profileprojects.leaderboard.services.ScoreService;
import com.profileprojects.leaderboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/score")
@CrossOrigin
public class ScoreController extends BaseController<ScoreService, Score, Long, ScoreRepository>{

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/addOrUpdate")
    public ResponseEntity<Score> addOrUpdate(final @RequestBody CreateOrUpdateScoreRequest createOrUpdateScoreRequest) {
        final Optional<Game> gameO = gameService.get(createOrUpdateScoreRequest.getGameId());
        final Optional<User> userO = userService.get(createOrUpdateScoreRequest.getUserId());

        if (gameO.isEmpty() || userO.isEmpty()) return ResponseEntity.notFound().build();
        final Score updatedScore = scoreService.createOrUpdateScore(
                createOrUpdateScoreRequest.getGameId(),
                createOrUpdateScoreRequest.getUserId(),
                createOrUpdateScoreRequest.getScore()
        );
        return ResponseEntity.ok(updatedScore);
    }

}
