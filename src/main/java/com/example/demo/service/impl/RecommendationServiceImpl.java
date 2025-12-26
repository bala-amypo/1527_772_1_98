package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.service.RecommendationService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public Recommendation generate(Long userId) {
        Recommendation rec = new Recommendation();
        rec.setUserId(userId);
        rec.setGeneratedAt(LocalDateTime.now());
        return recommendationRepository.save(rec);
    }

    @Override
    public Recommendation getLatest(Long userId) {
        return recommendationRepository.findByUserIdOrderByGeneratedAtDesc(userId)
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("No recommendation found"));
    }

    @Override
    public List<Recommendation> getAll(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }
}
