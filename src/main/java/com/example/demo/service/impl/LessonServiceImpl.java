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
        lesson.setId(lessonId);
        return lessonRepository.save(lesson);
    }

    @Override
    public List<MicroLesson> searchLessons(String tag, String difficulty, String contentType) {
        return lessonRepository.findByFilters(tag, difficulty, contentType);
    }

    @Override
    public MicroLesson getLessonById(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }
}
