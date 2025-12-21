package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime generatedAt;

    private String recommendedLessonIds;

    private String basisSnapshot;

    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private Double confidenceScore;

    @PrePersist
    void onCreate() {
        generatedAt = LocalDateTime.now();
    }
}