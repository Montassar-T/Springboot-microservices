package com.mdw.student_server.service;


import com.mdw.student_server.Repository.StudentRepository;
import com.mdw.student_server.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;




    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public Student updateStudent(Long id, Student student) {
        // Check if student exists
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setNom(student.getNom());
            updatedStudent.setPrenom(student.getPrenom());
            updatedStudent.setEmail(student.getEmail());

            updatedStudent.setSpecialite(student.getSpecialite());
            updatedStudent.setNiveau(student.getNiveau());

            // Save the updated student
            return studentRepository.save(updatedStudent);
        } else {
            // Optionally throw an exception if student not found
            throw new RuntimeException("Student not found with id: " + id);
        }
    }


    public List<Student> searchStudents(Long specialiteId, String niveau) {
        if (specialiteId != null) {
            // Assuming you have a relationship between Student and Specialite
            return studentRepository.findBySpecialiteId(specialiteId);
        } else if (niveau != null) {
            return studentRepository.findByNiveau(niveau);
        }

        // If no filter is applied, return all students
        return studentRepository.findAll();
    }


    public int getTotalStudents() {
        return (int) studentRepository.count();
    }
}
