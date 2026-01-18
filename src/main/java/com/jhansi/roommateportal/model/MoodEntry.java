package com.jhansi.roommateportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mood_entries")
public class MoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MoodType mood;

    private LocalDate date;

    public MoodEntry() {}

    public MoodEntry(String name, MoodType mood, LocalDate date) {
        this.name = name;
        this.mood = mood;
        this.date = date;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public MoodType getMood() { return mood; }
    public void setMood(MoodType mood) { this.mood = mood; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
