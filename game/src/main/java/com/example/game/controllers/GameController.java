package com.example.game.controllers;

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

    @GetMapping("/menu")
    public String getMenu() {
        return "Welcome to the game!";
    }

    @GetMapping("/run")
    public String gatRun() {
        return "Running";
    }
}
