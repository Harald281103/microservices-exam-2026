package com.example.auctionhouse.services;

import org.springframework.stereotype.Service;

@Service
public class AHServiceImpl implements AHService {

    @Override
    public String aHTest() {
        return "Test from AuctionHouse";
    }

}
