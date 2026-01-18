package com.jhansi.roommateportal.service;

import com.jhansi.roommateportal.model.DinnerOption;
import com.jhansi.roommateportal.model.DinnerVote;
import com.jhansi.roommateportal.repository.DinnerVoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DinnerPollService {

    private final DinnerVoteRepository repo;

    public DinnerPollService(DinnerVoteRepository repo) {
        this.repo = repo;
    }

    public DinnerVote saveVote(String name, DinnerOption option) {
        DinnerVote vote = new DinnerVote();
        vote.setName(name);
        vote.setVoteOption(option);
        vote.setVoteDate(LocalDate.now());   // 👈 DAILY RESET LOGIC

        return repo.save(vote);
    }

    public List<DinnerVote> getTodayVotes() {
        return repo.findByVoteDate(LocalDate.now());
    }
}
