package com.mwd.absence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate IDs
    private Long id;

    @NotNull(message = "Student ID is required")
    private Long studentId; // Reference to student in the Student Service

    @NotNull(message = "Date is required")
    private LocalDate date; // Date of absence

    @NotNull(message = "Reason is required")
    private String reason; // Reference to student in the Student Service

    @NotNull(message = "Subject is required")
    private String matiere; // Subject for which the student is absent
}
