package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.Catalog;
//import com.dh.movieservice.model.Movie;
//import com.dh.serie.model.Serie;
//import com.dh.movieservice.model.Movie;
//import com.dh.serie.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog,String> {
  // List<Catalog.Movie> findAllMoviesByGenre(String genre);
 // List<Catalog.Serie> findAllSeriesByGenre(String genre);
}
