package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.MicroLesson;
import com.example.demo.service.LessonService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@Tag(name = "Lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/course/{courseId}")
    public MicroLesson addLesson(@PathVariable Long courseId,
                                 @RequestBody MicroLesson lesson) {
        return lessonService.addLesson(courseId, lesson);
    }
    @PutMapping("/{lessonId}")
    public MicroLesson updateLesson(@PathVariable Long lessonId,
                                    @RequestBody MicroLesson lesson) {
        lesson.setId(lessonId);
        return lessonService.updateLesson(lesson);
    }
    @GetMapping("/search")
    public List<MicroLesson> searchLessons(@RequestParam(required = false) String tag,
                                           @RequestParam(required = false) String difficulty) {
        return lessonService.searchLessons(tag, difficulty);
    }

    @GetMapping("/{lessonId}")
    public MicroLesson getLesson(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }
}