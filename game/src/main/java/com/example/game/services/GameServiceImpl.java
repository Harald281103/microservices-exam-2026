package com.example.game.services;

import com.example.game.clients.GameClient;
import com.example.game.models.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameServiceImpl implements GameService{
    private Game game;

    private final GameClient client;

    @Override
    public String startGame() {
        game = new Game(5);
        game.setRunning(true);

        return "Game Started!";
    }

    @Override
    public String getAHItem(){
        return client.getAuctionItem();
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
