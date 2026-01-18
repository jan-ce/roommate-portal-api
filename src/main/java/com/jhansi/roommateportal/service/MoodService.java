package com.jhansi.roommateportal.service;

import com.jhansi.roommateportal.model.MoodEntry;
import com.jhansi.roommateportal.model.MoodType;
import com.jhansi.roommateportal.repository.MoodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MoodService {

    private final MoodRepository moodRepository;

    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    public MoodEntry saveMood(String name, MoodType mood) {
        MoodEntry entry = new MoodEntry(name, mood, LocalDate.now());
        return moodRepository.save(entry);
    }

    public List<MoodEntry> getTodayMoods() {
        return moodRepository.findByDate(LocalDate.now());
    }
}
