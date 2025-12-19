package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Recommendation;
import com.example.demo.repository.RecommendationRepository;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public Recommendation generate(Long userId) {
        Recommendation rec = new Recommendation();
        return recommendationRepository.save(rec);
    }

    @Override
    public Recommendation getLatest(Long userId) {
        return recommendationRepository.findByUserIdOrderByGeneratedAtDesc(userId);
    }

    @Override
    public List<Recommendation> getAll(Long userId) {
        return recommendationRepository.findAll();
    }
}