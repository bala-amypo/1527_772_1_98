package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MicroLesson;

public interface MicroLessonRepository extends JpaRepository<MicroLesson, Long> {
}