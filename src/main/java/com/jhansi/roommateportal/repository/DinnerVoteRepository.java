package com.jhansi.roommateportal.repository;

import com.jhansi.roommateportal.model.DinnerVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DinnerVoteRepository extends JpaRepository<DinnerVote, Long> {
    List<DinnerVote> findByVoteDate(LocalDate date);
}
