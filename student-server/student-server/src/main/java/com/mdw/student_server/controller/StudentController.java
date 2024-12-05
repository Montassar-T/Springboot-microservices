package com.mdw.student_server.controller;


import com.mdw.student_server.model.Student;
import com.mdw.student_server.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(
                                                        @RequestParam(required = false) Long specialiteId,
                                                        @RequestParam(required = false) String niveau) {
        List<Student> students = studentService.searchStudents(specialiteId, niveau);
        return ResponseEntity.ok(students); // Returns status 200 OK with the filtered list of students
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }


    // Endpoint pour récupérer le nombre total d'étudiants
    @GetMapping("/count")
    public int countStudents() {
        return studentService.getTotalStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) { return studentService.updateStudent(id, student); }
}
