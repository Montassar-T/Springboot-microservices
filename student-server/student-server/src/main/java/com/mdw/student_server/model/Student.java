package com.mdw.student_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Automatically generated primary key.

    @NotNull(message = "Surname cannot be null")
    private String nom;  // The surname of the student.

    @NotNull(message = "First name cannot be null")  // Fixed the error message.
    private String prenom;  // The first name of the student.


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "specialite_id") // foreign key column
    private Specialite specialite;  // The relation to Specialite


    private String niveau;  // Optional level of the student (e.g., Level 1, 2, 3).



    @Email(message = "Invalid email format")  // Email validation: must be a valid format.
    @NotNull(message = "Email cannot be null")  // Email cannot be null.
    @Column(unique = true)  // Database uniqueness constraint.
    private String email;  // The student's email address.

}
