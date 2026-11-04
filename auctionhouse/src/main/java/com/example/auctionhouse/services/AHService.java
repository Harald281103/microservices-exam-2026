package com.example.auctionhouse.services;

import com.example.auctionhouse.models.Item;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AHService {
    String aHTest();

    Item auctionItem();

    Item addItem(String name, String description, String image, int auctionPrice, int actualValue, boolean bought);

    List<Item> findAll();

    String testRemoveMoney();

    String placeBid(Long itemId, int amount);
}
