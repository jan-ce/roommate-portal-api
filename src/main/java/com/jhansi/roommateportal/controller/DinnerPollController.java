package com.jhansi.roommateportal.controller;

import com.jhansi.roommateportal.model.DinnerOption;
import com.jhansi.roommateportal.model.DinnerVote;
import com.jhansi.roommateportal.service.DinnerPollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dinner")
@CrossOrigin(origins = "http://localhost:3000")
public class DinnerPollController {

    private final DinnerPollService service;

    public DinnerPollController(DinnerPollService service) {
        this.service = service;
    }

    @PostMapping
    public DinnerVote vote(@RequestParam String name,
                            @RequestParam DinnerOption option) {
        return service.saveVote(name, option);
    }

    @GetMapping("/today")
    public List<DinnerVote> todayVotes() {
        return service.getTodayVotes();
    }
}
