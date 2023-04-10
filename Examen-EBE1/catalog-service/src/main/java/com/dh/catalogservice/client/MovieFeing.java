package com.dh.catalogservice.client;


import com.dh.catalogservice.config.LoadBalancerConfiguration;
import com.dh.catalogservice.model.Catalog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name= "movie-service")//,url = "http://localhost:8088/movie-service"
@LoadBalancerClient(value = "movie-service",configuration = LoadBalancerConfiguration.class)
public interface MovieFeing {

    @GetMapping("/movies/{genre}")
    List<MovieDto> getMovieByGenre(@PathVariable (value = "genre") String genre);

    @GetMapping("/movies/{id}")
    Optional<Catalog> getMovieById(@PathVariable (value = "id") String id);

    @GetMapping("/movies/{name}")
    List<MovieDto> getMovieByName(@PathVariable (value = "name") String name);
    @GetMapping("/movies")
    List<MovieDto> getAll();
    @Getter
    @Setter
    class MovieDto{
        private String id;

        private String name;

        private String genre;

        private String urlStream;


    }

}
