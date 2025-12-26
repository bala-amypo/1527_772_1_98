package com.example.demo.service;

import com.example.demo.model.Course;
import java.util.List;

public interface CourseService {

    Course saveCourse(Course course, Long instructorId); // was createCourse

    Course updateCourse(Long courseId, Course course);

    List<Course> getCoursesByInstructor(Long instructorId); // was listCoursesByInstructor

    Course getCourseById(Long courseId); // was getCourse
}
