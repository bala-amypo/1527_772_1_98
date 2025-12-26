package com.example.demo.repository;

import com.example.demo.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Progress findByUserIdAndMicroLessonId(Long userId, Long lessonId);
    List<Progress> findByUserIdOrderByLastAccessedAtDesc(Long userId);
}
