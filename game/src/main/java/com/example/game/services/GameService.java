package com.example.game.services;

import com.example.game.models.Item;

public interface GameService {

    String startGame();
    String stopGame();
    String gameStatus();
    Item getItem();
    String nextRound();
    String bid(int bid);
    String getTop10();

}
