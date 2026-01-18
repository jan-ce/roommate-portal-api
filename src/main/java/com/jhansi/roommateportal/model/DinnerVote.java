package com.jhansi.roommateportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DinnerVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private DinnerOption voteOption;

    private LocalDate voteDate;

    // getters & setters

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DinnerOption getVoteOption() { return voteOption; }
    public void setVoteOption(DinnerOption voteOption) { this.voteOption = voteOption; }

    public LocalDate getVoteDate() { return voteDate; }
    public void setVoteDate(LocalDate voteDate) { this.voteDate = voteDate; }
}
