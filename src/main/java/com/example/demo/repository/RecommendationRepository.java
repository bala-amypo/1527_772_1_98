package com.example.demo.repository;

import com.example.demo.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    @Query("SELECT r FROM Recommendation r WHERE r.user.id = :userId AND r.generatedAt BETWEEN :start AND :end")
    List<Recommendation> findByUserIdAndGeneratedAtBetween(Long userId, LocalDateTime start, LocalDateTime end);
    List<Recommendation> findByUserIdOrderByGeneratedAtDesc(Long userId);
}
