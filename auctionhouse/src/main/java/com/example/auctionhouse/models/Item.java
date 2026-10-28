package com.example.auctionhouse.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private String description;
    private String image;
    private int auctionPrice;
    private int actualValue;

    public Item(String name, String description, String image, int auctionPrice, int actualValue) {

        this.name = name;
        this.description = description;
        this.image = image;
        this.auctionPrice = auctionPrice;
        this.actualValue = actualValue;

    }
}
