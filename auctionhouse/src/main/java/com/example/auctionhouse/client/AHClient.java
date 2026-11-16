package com.example.auctionhouse.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Component
public class AHClient {

    private final RestClient restClientPlayer = RestClient.create(
            System.getenv().getOrDefault("PLAYER_URL", "http://localhost:8082"));

    public void removeMoney(int amount){
        restClientPlayer.post()
                .uri("/api/player/removeMoney?amount={amount}", amount)
                .retrieve()
                .toBodilessEntity();
    }

    public int getMoney(){
        return Objects.requireNonNull(restClientPlayer.get()
                .uri("/api/player/getMoney")
                .retrieve()
                .body(Integer.class));

    }
}
