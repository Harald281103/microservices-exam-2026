package com.example.game.controllers;

import com.example.game.services.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @GetMapping("/auction")
    public String getItem(){return gameService.getAHItem();}

    @GetMapping("/start")
    public String startGame() {
        return gameService.startGame();
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
