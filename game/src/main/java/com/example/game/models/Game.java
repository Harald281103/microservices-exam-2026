package com.example.game.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private boolean running;
    private int currentRound;
    private int maxRounds;
    private Long currentItemId;

    public Game(int maxRounds) {
        this.currentRound = 0;
        this.maxRounds = maxRounds;
        this.running = false;
    }

}
