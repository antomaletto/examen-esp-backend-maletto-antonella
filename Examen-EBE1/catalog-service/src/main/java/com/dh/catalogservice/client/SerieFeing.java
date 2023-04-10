package com.dh.catalogservice.client;

import com.dh.catalogservice.config.LoadBalancerConfiguration;



import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name= "serie-service")
@LoadBalancerClient(value = "serie-service",configuration = LoadBalancerConfiguration.class)
public interface SerieFeing {

    @GetMapping("/series/{genre}")
    List<SerieDto> getSerieByGenre(@PathVariable(value = "genre") String genre);


    @Getter
    @Setter
    class SerieDto{
        private String id;
        private String name;
        private String genre;

    }
}
