package com.example.auctionhouse.repository;

import com.example.auctionhouse.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AHRepository extends JpaRepository<Item, Long> {
}
