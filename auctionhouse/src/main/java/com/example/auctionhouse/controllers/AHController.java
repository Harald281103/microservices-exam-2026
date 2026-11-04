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

    @PostMapping("/addCat")
    public Item addCat(){return aHService.addItem("Cat", "cute", null, 200, 5000, false);}

    @GetMapping("/seeAll")
    public List<Item> findAll(){return aHService.findAll();}

    @GetMapping("/testMoney")
    public String testMoney(){return aHService.testRemoveMoney();}

    @PostMapping("/bid")
    public String placeBid(@RequestParam Long itemId, @RequestParam int amount){return aHService.placeBid(itemId, amount);}
}
