/*package com.dh.catalogservice.service;

import com.dh.catalogservice.client.MovieFeing;
import com.dh.catalogservice.client.SerieFeing;
import com.dh.catalogservice.model.Catalog;
import com.dh.catalogservice.repository.CatalogRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static org.bouncycastle.math.raw.Nat160.eq;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class CatalogServiceImplTest {

    @Mock
    private MovieFeing movieFeing;
    @Mock
    private SerieFeing serieFeing;

    @Mock
    private CatalogRepository catalogRepository;

    @InjectMocks
    private CatalogServiceImpl catalogService;

    @BeforeAll
    public void addToCatalog() {

        var newMovie= new Catalog.Movie("La casa de cera","Terror");
        var newSerie= new Catalog.Serie("Stranger things","Terror");
        var catalog= new Catalog("Terror", (List<Catalog.Movie>) newMovie, (List<Catalog.Serie>) newSerie);
        //when(movieFeing.getMovieById("1")).thenReturn(new MovieFeing.MovieDto("1","La casa de cera","Terror","url"));
        //when(catalogRepository.findById("1")).thenReturn(catalog);
        catalogRepository.save((catalog));
    }





    @Test
    void addMovie() {
        try {
            catalogService.addMovie(null,"La casa de cera");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


}}
*/
