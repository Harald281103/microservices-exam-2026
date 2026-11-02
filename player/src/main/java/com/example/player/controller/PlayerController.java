package com.example.player.controller;

import com.example.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/removeMoney")
    public void removeMoney(@RequestParam int amount){playerService.removeMoney(amount);}

    @GetMapping("/getMoney")
    public int getMoney(){return playerService.getMoney();}
}
