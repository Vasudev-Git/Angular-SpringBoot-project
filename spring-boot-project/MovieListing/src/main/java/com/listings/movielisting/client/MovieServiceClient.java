package com.listings.movielisting.client;

import com.listings.movielisting.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieServiceClient {

    @GET("/")
    Call<Movie> getMovies(@Query("i") String i,
                             @Query("apikey") String apikey);
}
