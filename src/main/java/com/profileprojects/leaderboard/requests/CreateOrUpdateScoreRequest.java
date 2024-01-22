package com.profileprojects.leaderboard.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrUpdateScoreRequest {

    @JsonProperty("user_id")
    @NotNull
    private Long userId;

    @JsonProperty("game_id")
    @NotNull
    private Long gameId;

    @JsonProperty("score")
    @NotNull
    private Double score;
}
