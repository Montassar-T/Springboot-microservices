package com.mwd.absence.service;

import com.mwd.absence.model.Absence;
import com.mwd.absence.repository.AbsenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Lombok will generate a constructor for the final fields
public class AbsenceService {

    private final AbsenceRepository absenceRepository; // Make this final

    // Create or update an absence
    public Absence createAbsence(Absence  absence) {


        return absenceRepository.save(absence);
    }



    public Absence updateStudent(Long id, Absence student) {
        // Check if student exists
        Optional<Absence> existingAbsence = absenceRepository.findById(id);

        if (existingAbsence.isPresent()) {
            Absence updatedStudent = existingAbsence.get();
            updatedStudent.setDate(student.getDate());
            updatedStudent.setStudentId(student.getStudentId());
            updatedStudent.setReason(student.getReason());

            updatedStudent.setMatiere(student.getMatiere());

            // Save the updated student
            return absenceRepository.save(updatedStudent);
        } else {
            // Optionally throw an exception if student not found
            throw new RuntimeException("Student not found with id: " + id);
        }
    }



    // Fetch total absences for the current month
    public int getTotalMonthlyAbsences() {
        LocalDate now = LocalDate.now();
        LocalDate startOfMonth = now.withDayOfMonth(1);
        return absenceRepository.countByDateBetween(startOfMonth, now);
    }

    // Fetch today's absences
    public int getTodaysAbsences() {
        LocalDate today = LocalDate.now();
        return absenceRepository.countByDate(today);
    }

    // Get all absences
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    // Get absence by ID
    public Optional<Absence> getAbsenceById(Long id) {
        return absenceRepository.findById(id);
    }

    // Delete absence by ID
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }
}
