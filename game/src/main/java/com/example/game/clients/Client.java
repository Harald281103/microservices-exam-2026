package com.example.game.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class Client {

    private final RestClient restClientAH = RestClient.create("http://localhost:8081");
    private final RestClient restClientPlayer = RestClient.create("http://localhost:8082");

    public String getAuctionItem(){
        return restClientAH.get()
                .uri("/api/auctionhouse/auction")
                .retrieve()
                .body(String.class);
    }

    public String getPlayer(){
        return restClientPlayer.get()
                .uri("/api/player")
                .retrieve()
                .body(String.class);
    }

    public void removeMoney(int amount){
        restClientPlayer.post()
                .uri("/api/player/removeMoney?amount={amount}")
                .retrieve()
                .toBodilessEntity();
    }
}
