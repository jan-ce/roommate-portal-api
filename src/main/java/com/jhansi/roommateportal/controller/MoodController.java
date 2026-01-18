package com.jhansi.roommateportal.controller;

import com.jhansi.roommateportal.model.MoodEntry;
import com.jhansi.roommateportal.model.MoodType;
import com.jhansi.roommateportal.service.MoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mood")
@CrossOrigin(origins = "http://localhost:3000")
public class MoodController {

    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @PostMapping
    public MoodEntry addMood(@RequestParam String name,
                             @RequestParam MoodType mood) {
        return moodService.saveMood(name, mood);
    }

    @GetMapping("/today")
    public List<MoodEntry> getTodayMoods() {
        return moodService.getTodayMoods();
    }
}
