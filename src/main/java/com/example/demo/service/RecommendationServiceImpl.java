package com.example.demo.service;

import com.example.demo.model.Recommendation;
import com.example.demo.model.User;
import com.example.demo.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public Recommendation generate(Long userId) {
        Recommendation recommendation = new Recommendation();

        User user = new User();
        user.setId(userId);     // ✔ CORRECT for your entity

        recommendation.setUser(user);

        return recommendationRepository.save(recommendation);
    }

    @Override
    public Recommendation getLatest(Long userId) {
        return recommendationRepository
                .findTopByUser_IdOrderByCreatedAtDesc(userId);
    }

    @Override
    public List<Recommendation> getAll(Long userId) {
        return recommendationRepository.findByUser_Id(userId);
    }
}
