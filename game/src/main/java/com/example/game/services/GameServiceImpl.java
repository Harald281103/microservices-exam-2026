package com.example.game.services;

import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    private boolean gameRunning  = false;

    @Override
    public String startGame() {
        gameRunning = true;
        return "Game Started!";
    }

    @Override
    public String stopGame() {
        gameRunning = false;
        return "Game Stopped!";
    }

    @Override
    public String gameStatus() {
        return gameRunning ? "Game Started!" : "Game Not Started!";
    }
}
