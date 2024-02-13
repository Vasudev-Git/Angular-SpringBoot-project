package com.listings.movielisting.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.listings.movielisting.client.MovieServiceClient;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class MovieServiceClientConfiguration {

    @Bean
    public MovieServiceClient movieServiceClient(final ObjectMapper objectMapper) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(Duration.of(30, ChronoUnit.SECONDS))
                .readTimeout(Duration.of(30, ChronoUnit.SECONDS));

        return new Retrofit.Builder().client(builder.build())
                .baseUrl("https://www.omdbapi.com")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build().create(MovieServiceClient.class);
    }

}
