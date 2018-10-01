package com.example.mauriciocaro.movies.Network;

import com.example.mauriciocaro.movies.Model.MovieRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET(URL.POPULAR)
    Call<MovieRetrofit> getPopularMovies();

    @GET(URL.TOP_RATED)
    Call<MovieRetrofit> getTopRatedMovies();
}
