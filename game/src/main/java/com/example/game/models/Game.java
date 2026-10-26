package com.example.game.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Game {

    @Setter
    private boolean running;
    private int currentRound;
    private int maxRounds;

    public  Game(int maxRounds) {
        this.currentRound = 0;
        this.maxRounds = maxRounds;
        this.running = false;
    }

}
