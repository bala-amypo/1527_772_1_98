package com.example.demo.service;

import com.example.demo.model.Recommendation;
import java.util.List;

public interface RecommendationService {

    Recommendation save(Long userId);

    Recommendation getLatest(Long userId);

    List<Recommendation> getAll(Long userId);
}
