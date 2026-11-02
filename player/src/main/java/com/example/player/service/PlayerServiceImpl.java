package com.example.player.service;

import com.example.player.model.Player;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PlayerServiceImpl implements PlayerService{
    private Player player = new Player(500, "Bob");

    public int removeMoney(int amount){
        player.setMoney(player.getMoney() - amount);
        return player.getMoney();
    }

    public int getMoney(){return player.getMoney();}

}
