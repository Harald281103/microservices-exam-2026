package com.example.game.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ScoreClient {
    private final RestClient restClientScore = RestClient.create("http://localhost:8084");

    public String getScore(){
        return restClientScore.get()
                .uri("/api/score/top10")
                .retrieve()
                .body(String.class);
    }
}
