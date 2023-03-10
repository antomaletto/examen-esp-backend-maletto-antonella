package com.dh.movieservice.service;


import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl {
	private final MovieRepository movieRepository;


	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}


	public List<Movie> getListByGenre(String genre) {
		return movieRepository.findAllByGenre(genre);
	}


	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
}
