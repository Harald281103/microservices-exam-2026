package com.example.auctionhouse.services;

import com.example.auctionhouse.models.Item;

import java.util.List;

public interface AHService {
    String aHTest();

    Item addItem(String name, String description, String image, int auctionPrice, int actualValue);

    List<Item> findAll();
}
