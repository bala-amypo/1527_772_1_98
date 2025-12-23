package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/progress")
@Tag(name = "Progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/{lessonId}")
    public Progress recordProgress(@PathVariable Long lessonId,
                                   @RequestBody Progress progress) {
        return progressService.saveProgress(lessonId, progress);
    }
    @GetMapping("/lesson/{lessonId}")
    public Progress getLessonProgress(@PathVariable Long lessonId,
                                      @RequestParam Long userId) {
        return progressService.getProgress(userId, lessonId);
    }
    @GetMapping("/user/{userId}")
    public List<Progress> getUserProgress(@PathVariable Long userId) {
        return progressService.getUserProgress(userId);
    }
}