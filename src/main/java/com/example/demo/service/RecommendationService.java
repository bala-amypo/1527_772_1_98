package com.example.demo.service;

import com.example.demo.model.Recommendation;
import java.util.List;

public interface RecommendationService {

    Recommendation save(Long lessonId, Recommendation recommendation);

    Recommendation getByUserAndLesson(Long userId, Long lessonId);

    List<Recommendation> getAll(Long userId);   // THIS MUST BE IMPLEMENTED
}
