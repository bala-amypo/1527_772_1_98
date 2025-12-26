package com.example.demo.service;

import com.example.demo.model.MicroLesson;
import java.util.List;

public interface LessonService {
    MicroLesson addLesson(Long courseId, MicroLesson lesson);
    MicroLesson updateLesson(Long lessonId, MicroLesson lesson);
    List<MicroLesson> searchLessons(String tag, String difficulty, String contentType);
    MicroLesson getLessonById(Long lessonId);
}
