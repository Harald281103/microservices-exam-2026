package com.example.auctionhouse.repository;

import com.example.auctionhouse.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Optional<Bid> findByItemId(Long id);
}
