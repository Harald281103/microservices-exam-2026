package com.example.auctionhouse.services;

import com.example.auctionhouse.models.Item;
import com.example.auctionhouse.repository.AHRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AHServiceImpl implements AHService {

    private final AHRepository aHRepository;

    @Override
    public Item addItem(String name, String description, String image, int auctionPrice, int actualValue, boolean bought){
        Item newItem = new Item(name, description, image, auctionPrice, actualValue, bought);
        return aHRepository.save(newItem);
    }

    @Override
    public List<Item> findAll(){
        return aHRepository.findAll();
    }

    @Override
    public Item auctionItem(){
        List<Item> items = aHRepository.findByBoughtFalse();

        if(items.isEmpty()){
            throw new IllegalStateException("No items found");
        }

        Random rand = new Random();

        int index =  rand.nextInt(items.size());
        Item auctionItem = items.get(index);

        return auctionItem;

    }

    @Override
    public String aHTest() {
        return "Test from AuctionHouse";
    }

}
