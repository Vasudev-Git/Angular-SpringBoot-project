package com.listings.movielisting.controller;

import com.listings.movielisting.model.Movie;
import com.listings.movielisting.service.MovieListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class MovieListingController {

    @Autowired
    private MovieListingService movieListingService;

    @GetMapping(value="/all-movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieListingService.fetchAllMovies());
    }

}
