package com.mdw.student_server.Repository;

import com.mdw.student_server.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    // Find students by their specialite ID (assuming a ManyToOne relationship between Student and Specialite)
    List<Student> findBySpecialiteId(Long specialiteId);
    // Find students by name and level
    List<Student> findByNomAndNiveau(String nom, String niveau);

    // Find students by name
    List<Student> findByNom(String nom);

    // Find students by first name
    List<Student> findByPrenom(String prenom);

    // Find students by level
    List<Student> findByNiveau(String niveau);
}
