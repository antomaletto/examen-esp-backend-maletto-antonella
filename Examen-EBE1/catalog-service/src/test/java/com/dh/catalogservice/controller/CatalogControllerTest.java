/*package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.Catalog;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


class CatalogControllerTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }



    @Test
    void addMovie() throws InterruptedException {
        var newMovie= new Catalog.Movie("La casa de cera","Terror");
        var newSerie= new Catalog.Serie("Stranger things","Terror");
        var responseGenre= given()
                .contentType(ContentType.JSON)
                .when()
                .body(new Catalog("Terror", (List<Catalog.Movie>) newMovie, (List<Catalog.Serie>) newSerie))
                .patch("catalog/movies/offline")
                .as(Map.class)              ;

        TimeUnit.SECONDS.sleep(10);


        given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("genre",responseGenre.get("genre"))
                .get("/catalog/{genre}/movies")
                .then()
                .statusCode(200)
                .body("name", equalTo("La casa de cera"));

        given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("genre",responseGenre.get("genre"))
                .delete("/catalog/{genre}/movies");
    }

    @Test
    void addSerie() throws InterruptedException {
        var newMovie= new Catalog.Movie("La casa de cera","Terror");
        var newSerie= new Catalog.Serie("Stranger things","Terror");
        var responseGenre= given()
                .contentType(ContentType.JSON)
                .when()
                .body(new Catalog("Terror", (List<Catalog.Movie>) newMovie, (List<Catalog.Serie>) newSerie))
                .patch("catalog/series/offline")
                .as(Map.class)              ;

        TimeUnit.SECONDS.sleep(10);


        given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("genre",responseGenre.get("genre"))
                .get("/catalog/{genre}/series")
                .then()
                .statusCode(200)
                .body("name", equalTo("Stranger things"));

        given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("genre",responseGenre.get("genre"))
                .delete("/catalog/{genre}/series");
    }


}*/