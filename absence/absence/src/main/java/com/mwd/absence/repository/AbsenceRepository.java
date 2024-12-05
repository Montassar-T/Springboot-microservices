package com.mwd.absence.repository;

import com.mwd.absence.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    // Count absences within a specific date range
    int countByDateBetween(LocalDate startDate, LocalDate endDate);

    // Count absences for a specific day
    int countByDate(LocalDate date);

}
