package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.MovieFeing;
//import com.dh.catalogservice.service.CatalogService;
//import com.dh.catalogservice.dto.CatalogWS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	//private CatalogService catalogService;
	private final MovieFeing movieFeing;

	public CatalogController(MovieFeing movieFeing) {
		this.movieFeing = movieFeing;
	}

	/*@Autowired
	public CatalogController(CatalogService catalogService, MovieFeing movieFeing) {
		this.catalogService = catalogService;
		this.movieFeing = movieFeing;
	}*/

	/*@GetMapping("/{genre}")
	ResponseEntity<CatalogWS> getCatalogByGenre(@PathVariable String genre) {
		return null;
	}*/
	@GetMapping("/{genre}")
	ResponseEntity<List<MovieFeing.MovieDto>> getGenre(@PathVariable String genre) {
		return ResponseEntity.ok(movieFeing.getMovieByGenre(genre));
	}
}
