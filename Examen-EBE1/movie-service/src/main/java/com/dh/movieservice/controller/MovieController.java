package com.dh.movieservice.controller;


import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private final MovieServiceImpl movieService;

	@Autowired
	public MovieController(MovieServiceImpl movieService) {
		this.movieService = movieService;

	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(movieService.getListByGenre(genre));
	}

	@PostMapping
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok().body(movieService.save(movie));
	}



}
