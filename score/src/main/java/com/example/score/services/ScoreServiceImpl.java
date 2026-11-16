package com.example.score.services;

import com.example.score.models.Score;
import com.example.score.repositories.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

    @Override
    public void createScore(String username, int points) {
        Score score = new Score();
        score.setUsername(username);
        score.setScore(points);

        scoreRepository.save(score);
    }

    @Override
    public void addScore(String username, int points) {
        Score score;
        score = scoreRepository.findByUsername(username).orElse(null);

        if(score == null) {
            createScore(username,points);
            return;
        }

        score.setScore(score.getScore() + points);
        scoreRepository.save(score);
    }

    @Override
    public List<Score> getTop10(){
        return scoreRepository.findTop10ByOrderByScoreDesc();
    }
}
