package com.example.game.controllers;

import com.example.game.models.Item;
import com.example.game.services.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @GetMapping("/auction")
    public Item getItem(){return gameService.getItem();}

    @GetMapping("/start")
    public String startGame() {
        return gameService.startGame();
    }

    @PostMapping("/nextRound")
    public String nextRound(){
        return gameService.nextRound();
    }

    @GetMapping("/stop")
    public String stopGame() {
        return gameService.stopGame();
    }

    @GetMapping("/status")
    public String gameStatus() {
        return gameService.gameStatus();
    }
}
