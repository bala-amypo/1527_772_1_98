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

    @Operation(summary = "Generate recommendation")
    @PostMapping("/generate")
    public Recommendation generate(@RequestParam Long userId) {
        return recommendationService.generate(userId);
    }

    @Operation(summary = "Get latest recommendation")
    @GetMapping("/latest")
    public Recommendation latest(@RequestParam Long userId) {
        return recommendationService.getLatest(userId);
    }

    @Operation(summary = "List user recommendations")
    @GetMapping("/user/{userId}")
    public List<Recommendation> getUserRecommendations(@PathVariable Long userId) {
        return recommendationService.getAll(userId);
    }
}