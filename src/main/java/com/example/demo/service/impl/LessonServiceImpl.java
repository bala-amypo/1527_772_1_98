package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private MicroLessonRepository lessonRepository;

    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        lesson.setCourseId(courseId);
        return lessonRepository.save(lesson);
    }

    @Override
    public MicroLesson updateLesson(Long lessonId, MicroLesson lesson) {
        MicroLesson existing = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        existing.setTitle(lesson.getTitle());
        existing.setContent(lesson.getContent());
        existing.setTag(lesson.getTag());
        existing.setDifficulty(lesson.getDifficulty());
        return lessonRepository.save(existing);
    }

    @Override
    public MicroLesson getLessonById(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    @Override
    public List<MicroLesson> searchLessons(String tag, String difficulty) {
        // Simple filter by tag/difficulty
        return lessonRepository.findAll().stream()
                .filter(l -> (tag == null || tag.equals(l.getTag())) &&
                             (difficulty == null || difficulty.equals(l.getDifficulty())))
                .toList();
    }
}
