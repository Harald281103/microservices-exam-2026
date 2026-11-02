package com.example.player.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private int money;
    private String playerName;

    public Player(int money, String playerName) {
        this.money  = money;
        this.playerName = playerName;
    }
}
