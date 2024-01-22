package com.profileprojects.leaderboard.services;

import com.profileprojects.leaderboard.entities.Score;
import com.profileprojects.leaderboard.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService extends BaseService<ScoreRepository, Score, Long> {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score createOrUpdateScore(final Long gameId, final Long userId, final Double score) {
        final Optional<Score> scoreO = getScoreByGameIdAndUserId(gameId, userId);

        if (scoreO.isEmpty()) return insertScore(gameId, userId, score);
        final Score sc = scoreO.get();
        sc.setScore(score);
        return update(sc, sc.getId());
    }

    public Optional<Score> getScoreByGameIdAndUserId(final Long gameId, final Long userId) {
        return scoreRepository.findByGameIdAndUserId(gameId, userId);
    }

    public Score insertScore(final Long gameId, final Long userId, final Double score) {
        final Score newScore = new Score();
        newScore.setGameId(gameId);
        newScore.setUserId(userId);
        newScore.setScore(score);
        return super.add(newScore);
    }

}
