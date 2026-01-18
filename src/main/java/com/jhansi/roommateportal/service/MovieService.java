package com.jhansi.roommateportal.service;

import com.jhansi.roommateportal.model.MovieEntry;
import com.jhansi.roommateportal.model.MovieStatus;
import com.jhansi.roommateportal.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public MovieEntry addMovie(String title) {
        MovieEntry m = new MovieEntry();
        m.setTitle(title);
        m.setStatus(MovieStatus.PENDING);
        m.setAddedDate(LocalDate.now());
        return repo.save(m);
    }

    public List<MovieEntry> getThisMonthsMovies() {
        YearMonth now = YearMonth.now();
        return repo.findByAddedDateBetween(
                now.atDay(1),
                now.atEndOfMonth()
        );
    }

    public MovieEntry markWatched(Long id) {
        MovieEntry m = repo.findById(id).orElseThrow();
        m.setStatus(MovieStatus.WATCHED);
        return repo.save(m);
    }
}
