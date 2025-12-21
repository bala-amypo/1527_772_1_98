package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private MicroLesson microLesson;

    @Enumerated(EnumType.STRING)
    private ProgressStatus status;

    @Min(0)
    @Max(100)
    private Integer progressPercent;

    private LocalDateTime lastAccessedAt;

    private Double score;

    @PrePersist
    void onAccess() {
        lastAccessedAt = LocalDateTime.now();
    }
}