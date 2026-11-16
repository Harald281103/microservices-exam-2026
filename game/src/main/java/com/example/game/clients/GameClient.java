package com.example.game.clients;

import com.example.game.models.Item;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GameClient {

    private final RestClient restClientAH = RestClient.create("http://localhost:8081");

    public Item getAuctionItem(){
        return restClientAH.get()
                .uri("/api/auctionhouse/auction")
                .retrieve()
                .body(Item.class);
    }

    public String finishAuction(Long itemId){
        return restClientAH.post()
                .uri("/api/auctionhouse/finishAuction?itemId={itemId}",itemId)
                .retrieve()
                .body(String.class);
    }

    public void addItems(){
        restClientAH.post()
                .uri("/api/auctionhouse/addItems")
                .retrieve()
                .toBodilessEntity();
    }

    public String bid(Long id,int amount){
        return restClientAH.post()
                .uri(uriBuilder -> uriBuilder.path("/api/auctionhouse/bid")
                        .queryParam("itemId", id)
                        .queryParam("amount", amount)
                        .build())
                .retrieve()
                .body(String.class);
    }

}
