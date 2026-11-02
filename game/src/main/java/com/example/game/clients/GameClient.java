package com.example.game.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GameClient {

    private final RestClient restClientAH = RestClient.create("http://localhost:8081");

    public String getAuctionItem(){
        return restClientAH.get()
                .uri("/api/auctionhouse/auction")
                .retrieve()
                .body(String.class);
    }
}
