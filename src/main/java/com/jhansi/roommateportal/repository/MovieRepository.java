package com.jhansi.roommateportal.repository;

import com.jhansi.roommateportal.model.MovieEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntry, Long> {

    List<MovieEntry> findByAddedDateBetween(LocalDate start, LocalDate end);
}
