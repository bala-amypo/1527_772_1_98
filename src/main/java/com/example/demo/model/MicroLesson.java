package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MicroLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course course;

    @NotBlank
    private String title;

    @Min(1)
    @Max(15)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String tags;

    private LocalDate publishDate;
}