package com.profileprojects.leaderboard.repositories;

import com.profileprojects.leaderboard.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
