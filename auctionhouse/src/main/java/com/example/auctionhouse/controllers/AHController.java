package com.example.auctionhouse.controllers;

import com.example.auctionhouse.services.AHService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auctionhouse")
public class AHController {
    private final AHService aHService;

    @GetMapping("/test")
    public String test(){return aHService.aHTest();}
}
