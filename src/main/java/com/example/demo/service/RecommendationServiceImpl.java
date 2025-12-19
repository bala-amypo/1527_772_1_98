package com.example.demo.service;

import com.example.demo.model.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public Recommendation save(Long userId) {
        Recommendation recommendation = new Recommendation();
        recommendation.setUserId(userId);
        return recommendationRepository.save(recommendation);
    }

    @Override
    public Recommendation getLatest(Long userId) {
        return recommendationRepository
                .findTopByUserIdOrderByCreatedAtDesc(userId);
    }

    @Override
    public List<Recommendation> getAll(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }
}
