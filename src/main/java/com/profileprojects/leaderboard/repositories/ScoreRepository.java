package com.profileprojects.leaderboard.repositories;

import com.profileprojects.leaderboard.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    Optional<Score> findByGameIdAndUserId(Long gameId, Long userId);
}
