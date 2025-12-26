package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MicroLesson;
import java.util.List;

public interface MicroLessonRepository extends JpaRepository<MicroLesson, Long> {
    List<MicroLesson> findByCourseId(Long courseId);
}
