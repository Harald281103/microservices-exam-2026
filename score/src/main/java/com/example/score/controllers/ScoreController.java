package com.example.score.controllers;

import com.example.score.models.Score;
import com.example.score.repositories.ScoreRepository;
import com.example.score.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/score")
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping("/top10")
    public List<Score> getTop10ByOrderByScoreDesc(){return scoreService.getTop10();}
}
