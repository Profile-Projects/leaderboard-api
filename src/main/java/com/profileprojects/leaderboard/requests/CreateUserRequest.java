package com.profileprojects.leaderboard.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.profileprojects.leaderboard.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("game_id")
    private Long gameId;

    public User toUser() {
        final var user = new User();
        user.setGameId(gameId);
        user.setName(name);
        return user;
    }
}
