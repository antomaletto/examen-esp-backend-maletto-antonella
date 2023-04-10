package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.MovieFeing;

import com.dh.catalogservice.client.SerieFeing;

import com.dh.catalogservice.event.CatalogEventProducer;
import com.dh.catalogservice.service.CatalogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
private final CatalogServiceImpl catalogService;
	private final MovieFeing movieFeing;
	private final SerieFeing serieFeing;

private final CatalogEventProducer catalogEventProducer;

	public CatalogController(CatalogServiceImpl catalogService, MovieFeing movieFeing, SerieFeing serieFeing, CatalogEventProducer catalogEventProducer) {
		this.catalogService = catalogService;
		this.movieFeing = movieFeing;


		this.serieFeing = serieFeing;

		this.catalogEventProducer = catalogEventProducer;
	}

	@GetMapping("/{genre}/movies")
	ResponseEntity<List<MovieFeing.MovieDto>> getGenreMovies(@PathVariable String genre) {
		return ResponseEntity.ok(movieFeing.getMovieByGenre(genre));
	}

	@PatchMapping("/movies/offline")
	@ResponseStatus(code = HttpStatus.OK)
	public void catalogMovieEvent()  {
		//CatalogEventProducer.Data event;
		catalogEventProducer.publishCatalogEventMovie( new CatalogEventProducer.Data("Terror","La casa de cera","New Movie"));
		//catalogService.addMovie(event.getName(),event.getGenre());
		//return ResponseEntity.ok(movieFeing.getMovieByGenre(event.getGenre()));
	}

	@GetMapping("/{genre}/movies/offline")
	ResponseEntity<List<MovieFeing.MovieDto>> getCatalogMoviesByGenre(@PathVariable String genre) {
		return ResponseEntity.ok(movieFeing.getMovieByGenre(genre));
	}

	@GetMapping("/{genre}/series")
	ResponseEntity<List<SerieFeing.SerieDto>> getGenreSeries(@PathVariable String genre) {
		return ResponseEntity.ok(serieFeing.getSerieByGenre(genre));
	}

	@PatchMapping("/series/offline")
	@ResponseStatus(code = HttpStatus.OK)
	public void catalogSerieEvent(){
		catalogEventProducer.publishCatalogEventSerie(new CatalogEventProducer.Data("Terror","Stranger things","New Serie"));
	}




}
