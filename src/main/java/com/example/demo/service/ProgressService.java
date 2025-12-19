package com.example.demo.service;

import com.example.demo.model.Progress;
import java.util.List;

public interface ProgressService {
    Progress saveProgress(Long lessonId, Progress progress);
    Progress getProgress(Long userId, Long lessonId);
    List<Progress> getUserProgress(Long userId);
}