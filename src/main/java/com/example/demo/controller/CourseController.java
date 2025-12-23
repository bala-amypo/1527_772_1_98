package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Tag(name = "Courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Create course")
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Long courseId,
                               @RequestBody Course course) {
        course.setId(courseId);
        return courseService.saveCourse(course);
    }

    @Operation(summary = "List instructor courses")
    @GetMapping("/instructor/{instructorId}")
    public List<Course> getInstructorCourses(@PathVariable Long instructorId) {
        return courseService.getCoursesByInstructor(instructorId);
    }

    @Operation(summary = "Get course details")
    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }
}