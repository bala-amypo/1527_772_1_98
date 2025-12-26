package com.example.demo.service;

import com.example.demo.model.MicroLesson;
import java.util.List;

public interface LessonService {

    MicroLesson saveLesson(Long courseId, MicroLesson lesson);

    MicroLesson updateLesson(Long lessonId, MicroLesson lesson); // corrected signature

    List<MicroLesson> searchLessons(String tags, String difficulty, String contentType); // corrected signature

    MicroLesson getLessonById(Long lessonId);
}
