package com.mdw.student_server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialites")
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Automatically generated primary key.

    @Column(unique = true, nullable = false)
    private String name;  // The name of the specialty (e.g., "TI", "GE", "SEG").

}
