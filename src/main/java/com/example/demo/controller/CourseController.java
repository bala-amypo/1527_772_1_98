package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Long courseId, @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Course> getInstructorCourses(@PathVariable Long instructorId) {
        return courseService.getCoursesByInstructor(instructorId);
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }
}
