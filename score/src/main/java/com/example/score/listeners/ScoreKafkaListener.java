package com.example.score.listeners;

import com.example.score.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScoreKafkaListener {
    private final ScoreService scoreService;

    @KafkaListener(topics = "auction-win", groupId = "score-service")
    public void reciveAuction(String message) {
        String[] split = message.split(",");

        System.out.println("motokk: "+message);

        String username = split[0].trim();
        int score = Integer.parseInt(split[1].trim());

        scoreService.addScore(username,score);
    }
}
