package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Progress;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.service.ProgressService;
import java.util.Optional;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public Progress saveProgress(Long userId, Progress progress) {
        progress.setUserId(userId);
        return progressRepository.save(progress);
    }

    @Override
    public Progress getProgress(Long userId, Long lessonId) {
        Optional<Progress> optional = progressRepository.findByUserIdAndLessonId(userId, lessonId);
        return optional.orElse(null);
    }
}
