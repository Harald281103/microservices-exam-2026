package com.example.auctionhouse.controllers;

import com.example.auctionhouse.models.Item;
import com.example.auctionhouse.services.AHService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auctionhouse")
public class AHController {
    private final AHService aHService;

    @GetMapping("/test")
    public String test(){return aHService.aHTest();}

    @GetMapping("/auction")
    public Item auctionItem(){return aHService.auctionItem();}

    @PostMapping("/addItems")
    public String addItems(){
        aHService.addItem("Cat", "cute", null, 200, 5000, false);
        aHService.addItem("Dog", "woof", null, 200, 5000, false);
        aHService.addItem("Rock", "just a rock", null, 50, 100, false);
        aHService.addItem("Penguin", "quack?", null, 200, 5000, false);
        aHService.addItem("Naponelons hat", "his personal hat",null, 250, 4000, false );
        aHService.addItem("The Moon", "just a very big rock", null, 450, 1000000, false );
        return "Successfully added items";
    }

    @GetMapping("/seeAll")
    public List<Item> findAll(){return aHService.findAll();}

    @GetMapping("/testMoney")
    public String testMoney(){return aHService.testRemoveMoney();}

    @PostMapping("/bid")
    public String placeBid(@RequestParam Long itemId, @RequestParam int amount){return aHService.placeBid(itemId, amount);}

    @PostMapping("/finishAuction")
    public String finishAuction(@RequestParam Long itemId){return aHService.finishAuction(itemId);}
}
