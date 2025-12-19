package com.example.demo.controller;

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/{userId}")
    public Recommendation generate(@PathVariable Long userId) {
        return recommendationService.generate(userId);
    }

    @GetMapping("/latest/{userId}")
    public Recommendation getLatest(@PathVariable Long userId) {
        return recommendationService.getLatest(userId);
    }

    @GetMapping("/{userId}")
    public List<Recommendation> getAll(@PathVariable Long userId) {
        return recommendationService.getAll(userId);
    }
}
