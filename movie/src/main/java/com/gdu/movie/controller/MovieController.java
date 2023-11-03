package com.gdu.movie.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // ajax 컨트롤러 ajax 이외는 작동 안함
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value="/searchAllMovies", produces="application/json")
    public Map<String, Object> searchAllMovies() {
        return movieService.getMovieList();
    }

    @GetMapping(value="/searchMovies", produces="application/json")
    public Map<String, Object> searchMovies(@RequestParam String title) {
        return movieService.getSearchMovieList(title);
    }
}
