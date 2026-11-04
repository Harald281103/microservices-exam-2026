package com.example.auctionhouse.services;

import com.example.auctionhouse.client.AHClient;
import com.example.auctionhouse.models.Bid;
import com.example.auctionhouse.models.Bidder;
import com.example.auctionhouse.models.Item;
import com.example.auctionhouse.repository.AHRepository;
import com.example.auctionhouse.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AHServiceImpl implements AHService {

    private final AHRepository aHRepository;
    private final AHClient client;
    private final BidRepository bidRepository;

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

    @Override
    public String testRemoveMoney(){
        int remove = 200;;
        client.removeMoney(remove);
        int money = client.getMoney();
        return "removed "+remove+"kr from player\n" +
                "they now have "+money+"kr left";
    }

    @Override
    public String placeBid(Long itemId, int amount){
        Optional<Bid> exsistingBid = bidRepository.findByItemId(itemId);
        Item item = aHRepository.findById(itemId).orElse(null);

        Bid bid;

        if(item == null){return "item does not exist";}
        if(item.isBought()){return "item is bought";}

        int money = client.getMoney();
        if(amount <= 0){return "The bid must be positive and over 0!";}
        if(amount < item.getAuctionPrice()){return "Bid must be higher than the price!";}
        if(amount > money){return "You dont have enough money!!!";}

        if(exsistingBid.isPresent()){
            bid = exsistingBid.get();
            if(amount <= bid.getAmount()){
                return "Bid must be higher than previous bid!";
            }

        }
        else {
            bid = new Bid();
            bid.setItemId(itemId);
        }

        bid.setBidder(Bidder.Player);
        bid.setAmount(amount);

        bidRepository.save(bid);

        return Bidder.Player+" has biddet "+amount+"kr";
    }

}
