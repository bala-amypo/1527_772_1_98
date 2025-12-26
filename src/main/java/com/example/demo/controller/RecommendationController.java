package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@Tag(name = "Recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/user/{userId}/generate")
    public Recommendation generateRecommendation(@PathVariable Long userId) {
        return recommendationService.generate(userId);
    }

    @GetMapping("/user/{userId}/latest")
    public Recommendation getLatestRecommendation(@PathVariable Long userId) {
        return recommendationService.getLatest(userId);
    }

    @GetMapping("/user/{userId}/all")
    public List<Recommendation> getAllRecommendations(@PathVariable Long userId) {
        return recommendationService.getAll(userId);
    }
}
