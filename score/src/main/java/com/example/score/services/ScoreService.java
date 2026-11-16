package com.example.score.services;

import com.example.score.models.Score;

import java.util.List;

public interface ScoreService{
    void createScore(String username, int score);
    void addScore(String username, int score);
    List<Score> getTop10();
}
