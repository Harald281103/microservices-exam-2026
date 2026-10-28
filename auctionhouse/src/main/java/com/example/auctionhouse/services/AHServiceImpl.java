package com.example.auctionhouse.services;

import com.example.auctionhouse.models.Item;
import com.example.auctionhouse.repository.AHRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AHServiceImpl implements AHService {

    private final AHRepository aHRepository;

    @Override
    public Item addItem(String name, String description, String image, int auctionPrice, int actualValue){
        Item newItem = new Item(name, description, image, auctionPrice, actualValue);
        return aHRepository.save(newItem);
    }

    @Override
    public List<Item> findAll(){
        return aHRepository.findAll();
    }

    @Override
    public String aHTest() {
        return "Test from AuctionHouse";
    }

}
