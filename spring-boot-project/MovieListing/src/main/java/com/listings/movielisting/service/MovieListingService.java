package com.listings.movielisting.service;

import com.listings.movielisting.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieListingService {

    @Autowired
    private MovieServiceProvider movieServiceProvider;

    public List<Movie> fetchAllMovies() {
        try {
            return movieServiceProvider.fetchAllMovies();
        } catch (Exception e) {
            System.out.println("Some exception occurred");
        }
        return null;
    }
}
