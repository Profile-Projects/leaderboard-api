package com.profileprojects.leaderboard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonProperty("game_id")
    @Column(name = "game_id")
    private Long gameId;

    @Column
    @JsonProperty("name")
    private String name;
}
