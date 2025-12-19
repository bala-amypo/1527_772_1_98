package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Progress;
import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Progress findByUserIdAndMicroLessonId(Long userId, Long microLessonId);

    List<Progress> findByUserIdOrderByLastAccessedAtDesc(Long userId);
}