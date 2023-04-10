package com.dh.serie.service;

import com.dh.serie.model.Serie;
import com.dh.serie.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl {

    private final SerieRepository serieRepository;


    public SerieServiceImpl(SerieRepository repository) {
        this.serieRepository = repository;
    }

    public List<Serie> getAll() {
        return serieRepository.findAll();
    }

    public List<Serie> getSeriesBygGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    public String create(Serie serie) {
        serieRepository.save(serie);
        return serie.getId();
    }
}
