package com.jhansi.roommateportal.repository;

import com.jhansi.roommateportal.model.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MoodRepository extends JpaRepository<MoodEntry, Long> {
    List<MoodEntry> findByDate(LocalDate date);
}
