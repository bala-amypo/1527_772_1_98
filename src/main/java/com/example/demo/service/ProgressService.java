package com.example.demo.service;

import com.example.demo.model.Progress;

public interface ProgressService {
    Progress saveProgress(Long userId, Progress progress);
    Progress getProgress(Long userId, Long lessonId);  // <-- Add this
}
