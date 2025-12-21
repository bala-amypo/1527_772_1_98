package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private MicroLesson microLesson;

    @NotBlank
    private String status;

    @Min(0)
    @Max(100)
    private Integer progressPercent;

    private LocalDateTime lastAccessedAt;

    private Double score;

    @PrePersist
    void onPersist() {
        this.lastAccessedAt = LocalDateTime.now();
    }
}
