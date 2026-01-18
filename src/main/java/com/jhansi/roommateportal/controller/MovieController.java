package com.jhansi.roommateportal.controller;

import com.jhansi.roommateportal.model.MovieEntry;
import com.jhansi.roommateportal.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public MovieEntry addMovie(@RequestParam String title) {
        return service.addMovie(title);
    }

    @GetMapping("/month")
    public List<MovieEntry> getMonthlyMovies() {
        return service.getThisMonthsMovies();
    }

    @PutMapping("/{id}/watched")
    public MovieEntry markWatched(@PathVariable Long id) {
        return service.markWatched(id);
    }
}
