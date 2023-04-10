package com.dh.catalogservice.model;

//import com.dh.catalogservice.client.SerieFeing;
import com.dh.catalogservice.client.MovieFeing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Document(collection = "Catalog")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Catalog {
    @Id
    private String genre;
    private List<Catalog.Movie> movies = new ArrayList<>();
    private List<Catalog.Serie> series = new ArrayList<>();




    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Movie{

        private String name;
        private String movieGenre;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Serie{

        private String name;
        private String serieGenre;
    }

}
