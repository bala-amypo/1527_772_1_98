package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.MicroLessonRepository;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private MicroLessonRepository lessonRepository;

    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public MicroLesson updateLesson(MicroLesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public MicroLesson getLessonById(Long lessonId) {
        return lessonRepository.findById(lessonId).orElse(null);
    }

    @Override
    public List<MicroLesson> searchLessons(String tag, String difficulty) {
        return lessonRepository.findAll();
    }
}