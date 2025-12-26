package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/progress")
@Tag(name = "Progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/user/{userId}")
    public Progress saveProgress(@PathVariable Long userId,
                                 @RequestBody Progress progress) {
        return progressService.saveProgress(userId, progress);
    }

    @GetMapping("/user/{userId}/lesson/{lessonId}")
    public Progress getProgress(@PathVariable Long userId,
                                @PathVariable Long lessonId) {
        return progressService.getProgress(userId, lessonId);
    }
}
