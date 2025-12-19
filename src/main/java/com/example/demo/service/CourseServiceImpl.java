package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public List<Course> getCoursesByInstructor(Long instructorId) {
        return courseRepository.findAll(); 
    }
}