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
    public Recommendation save(Long lessonId, Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    @Override
    public Recommendation getByUserAndLesson(Long userId, Long lessonId) {
        return recommendationRepository.findByUserIdAndLessonId(userId, lessonId);
    }

    @Override
    public List<Recommendation> getAll(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }
}
