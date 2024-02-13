package com.listings.movielisting.service;

import com.listings.movielisting.client.MovieServiceClient;
import com.listings.movielisting.model.Movie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceProvider {

    @Autowired
    private MovieServiceClient movieServiceClient;

    public List<Movie> fetchAllMovies() throws IOException {
        Response<Movie> movieResponse = movieServiceClient.getMovies("tt3896198", "fa49b16a").execute();
        List<Movie> movieList = new ArrayList<>();
        if (movieResponse.isSuccessful()) {
            Movie body = movieResponse.body();
            for(int i=0; i<5; i++) {
                Movie newMovieObject = new Movie();
                BeanUtils.copyProperties(body, newMovieObject);
                movieList.add(newMovieObject);
            }
            System.out.println("Success response received and the ResponseBody is: " + body);
        } else {
            System.out.println("Failure response received and the ErrorBody is: " + movieResponse.errorBody());
        }
        return movieList;
    }

}
