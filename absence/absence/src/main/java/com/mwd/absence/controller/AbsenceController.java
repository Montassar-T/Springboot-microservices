package com.mwd.absence.controller;

import com.mwd.absence.model.Absence;
import com.mwd.absence.service.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/absence")
public class AbsenceController {

    private final AbsenceService service;

    // Create an absence
    @PostMapping
    public ResponseEntity<Absence> createAbsence(@RequestBody Absence ab) {
        Absence absence = service.createAbsence(ab);
        return new ResponseEntity<>(absence, HttpStatus.CREATED);
    }

    // Get all absences
    @GetMapping
    public List<Absence> getAllAbsences() {
        return service.getAllAbsences();
    }



    @GetMapping("/monthly")
    public int getTotalMonthlyAbsences() {
        return service.getTotalMonthlyAbsences();
    }

    // Endpoint for today's absences
    @GetMapping("/today")
    public int getTodaysAbsences() {
        return service.getTodaysAbsences();
    }

    // Get absence by ID
    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Long id) {
        Optional<Absence> absence = service.getAbsenceById(id);
        return absence.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete absence by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        service.deleteAbsence(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Absence updateStudent(@PathVariable Long id, @RequestBody Absence absence) { return service.updateStudent(id, absence); }




}
