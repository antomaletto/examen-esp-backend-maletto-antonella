
package com.dh.catalogservice.service;


import com.dh.catalogservice.client.MovieFeing;
import com.dh.catalogservice.client.SerieFeing;

import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.repository.CatalogRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl {
    private final MovieFeing movieFeing;
    private final SerieFeing serieFeing;
    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl(MovieFeing movieFeing, SerieFeing serieFeing, CatalogRepository catalogRepository) {
        this.movieFeing = movieFeing;
        this.serieFeing = serieFeing;
        this.catalogRepository = catalogRepository;
    }

    public void create(String genre,String movieGenre, String serieGenre) {
        MovieFeing.MovieDto movie = (MovieFeing.MovieDto) findMovie(movieGenre);
        SerieFeing.SerieDto serie = (SerieFeing.SerieDto) findSerie(serieGenre);
        Catalog catalog = new Catalog();
        //catalog.setId(UUID.randomUUID().toString());
        catalog.setGenre("terror");
        catalog.setMovies((List<Catalog.Movie>) new Catalog.Movie(movie.getGenre(),movie.getName()));
        catalog.setSeries((List<Catalog.Serie>) new Catalog.Serie(serie.getGenre(),serie.getName()));
        catalogRepository.save(catalog);
    }
    public void addMovie(String movieId,String name) throws Exception {
        var catalog= catalogRepository.findById(movieId);
        if (catalog.isPresent()){
            var result= movieFeing.getMovieByName(name);
            if (result==null) {
                throw new Exception("Pelicula no encontrada");
            }
            catalog.get().getMovies().add(new Catalog.Movie("El exorcista","Terror"));
            catalogRepository.save(catalog.get());
            }
        else {
            throw  new Exception("No está en el catálogo");
        }
    }

    @Retry(name = "movie")
    @CircuitBreaker(name = "movie", fallbackMethod = "findMovieFallBack")
    private List<MovieFeing.MovieDto> findMovie(String movieGenre) {
        var movie = movieFeing.getMovieByGenre(movieGenre);
        return (List<MovieFeing.MovieDto>) movie;
    }

    public List<MovieFeing.MovieDto> findMovieFallBack(String movieGenre, Throwable t) throws Exception {
        throw new Exception("Not found Movie");
    }

    @Retry(name = "serie")
    @CircuitBreaker(name = "serie", fallbackMethod = "findSerieFallBack")
    private List<SerieFeing.SerieDto> findSerie(String serieGenre) {
        var serie = serieFeing.getSerieByGenre(serieGenre);
        return (List<SerieFeing.SerieDto>) serie;
    }

    public List<SerieFeing.SerieDto> findSerieFallBack(String serieGenre, Throwable t) throws Exception {
        throw new Exception("Not found Serie");
    }

}




