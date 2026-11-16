package com.example.game.services;

import com.example.game.clients.GameClient;
import com.example.game.clients.ScoreClient;
import com.example.game.models.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.game.models.Item;

@RequiredArgsConstructor
@Service
public class GameServiceImpl implements GameService{
    private Game game;

    private final GameClient client;
    private final ScoreClient sClient;

    @Override
    public String startGame() {
        game = new Game(5);
        game.setRunning(true);
        game.setCurrentRound(1);

        client.addItems();

        Item item = client.getAuctionItem();
        game.setCurrentItemId(item.getId());

        return "Game Started!\nRound 1: item being sold: "+item.getName()+" for "+item.getAuctionPrice()+"kr";
    }

    @Override
    public Item getItem(){
        if (game == null || !game.isRunning()){
            throw new IllegalStateException("Game is not running");
        }
        if(game.getCurrentItemId() != null){
            throw new  IllegalStateException("there is already an item in current game");
        }

        Item item = client.getAuctionItem();
        game.setCurrentItemId(item.getId());
        return item;
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

    @Override
    public String nextRound() {
        if((game == null) || !game.isRunning()){return "Game Not Started!";}

        Long itemId = game.getCurrentItemId();
        if(itemId == null){return "no active item";}

        String result = client.finishAuction(itemId);

        if(game.getCurrentRound() >= game.getMaxRounds()){
            game.setRunning(false);
            game.setCurrentItemId(null);
            return result+"\nGame finished!";
        }

        game.setCurrentRound(game.getCurrentRound()+1);
        Item item = client.getAuctionItem();
        game.setCurrentItemId(item.getId());

        return result+"\nStarting Round "+game.getCurrentRound()+", New item is: "+item.getName()+" for "+item.getAuctionPrice()+"kr";
    }

    @Override
    public String bid(int amount){
        if(game == null || !game.isRunning() || game.getCurrentItemId() == null){return "No ongoing auction";}
        return client.bid(game.getCurrentItemId(), amount);
    }

    @Override
    public String getTop10() {
        return sClient.getScore();
    }

}
