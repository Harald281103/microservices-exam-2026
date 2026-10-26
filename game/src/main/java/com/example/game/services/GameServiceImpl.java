package com.example.game.services;

import com.example.game.models.Game;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    private Game game;

    @Override
    public String startGame() {
        game = new Game(5);
        game.setRunning(true);

        return "Game Started!";
    }

    @Override
    public String stopGame() {
        game.setRunning(false);
        return "Game Stopped!";
    }

    @Override
    public String gameStatus() {
        if(game == null){return "Game Not Started!";}

        return game.isRunning() ? "Game Running!" : "Game Not Running!";
    }
}
