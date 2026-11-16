package com.example.score.repositories;

import com.example.score.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    Optional<Score> findByUsername(String username);
    List<Score> findTop10ByOrderByScoreDesc();
}
