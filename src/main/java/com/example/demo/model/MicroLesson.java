package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class MicroLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Course course;

    @NotBlank
    private String title;

    @Min(1)
    @Max(15)
    private Integer durationMinutes;

    @NotBlank
    private String contentType;

    @NotBlank
    private String difficulty;

    private String tags;

    private LocalDate publishDate;
}
