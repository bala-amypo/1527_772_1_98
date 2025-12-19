package com.example.demo.service;

import com.example.demo.model.MicroLesson;
import java.util.List;

public interface LessonService {
    MicroLesson addLesson(Long courseId, MicroLesson lesson);
    MicroLesson updateLesson(MicroLesson lesson);
    MicroLesson getLessonById(Long lessonId);
    List<MicroLesson> searchLessons(String tag, String difficulty);
}