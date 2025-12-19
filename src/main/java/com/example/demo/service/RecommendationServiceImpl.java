package com.example.demo.service;

import com.example.demo.model.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<Recommendation> getRecommendationsByUser(Long userId) {
        return recommendationRepository
                .findByUserIdOrderByCreatedAtDesc(userId);
    }

    @Override
    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }
}