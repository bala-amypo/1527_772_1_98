package com.example.demo.service;

import com.example.demo.model.Recommendation;
import com.example.demo.model.User;
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
    public Recommendation generate(Long userId) {
        Recommendation recommendation = new Recommendation();

        User user = new User();
        user.setId(userId);   // correct: reference by ID only

        recommendation.setUser(user);

        return recommendationRepository.save(recommendation);
    }

    @Override
    public Recommendation getLatest(Long userId) {
        return recommendationRepository
                .findTopByUser_IdOrderByGeneratedAtDesc(userId);
    }

    @Override
    public List<Recommendation> getAll(Long userId) {
        return recommendationRepository.findByUser_Id(userId);
    }
}
