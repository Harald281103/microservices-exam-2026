package com.example.game.clients;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AHClient {

    private final RestClient restClient = RestClient.create("http://localhost:8081");

    public String getAuctionItem(){
        return restClient.get()
                .uri("/api/auctionhouse/auction")
                .retrieve()
                .body(String.class);
    }
}
