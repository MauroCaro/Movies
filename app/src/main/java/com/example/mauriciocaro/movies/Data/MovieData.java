package com.example.mauriciocaro.movies.Data;

import com.example.mauriciocaro.movies.Activity.MainActivityView;
import com.example.mauriciocaro.movies.Model.MovieRetrofit;
import com.example.mauriciocaro.movies.Network.Connection;
import com.example.mauriciocaro.movies.Network.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that fetch the information from the server and handle the response
 *
 * @author mauricio.caro
 */
public class MovieData {
    Service serviceConnection;
    MainActivityView listener;

    public MovieData(MainActivityView listener) {
        this.listener = listener;
        serviceConnection = Connection.getRetrofitInstance().create(Service.class);
    }

    public void fetchPopularMovie() {
        Call<MovieRetrofit> call = serviceConnection.getPopularMovies();
        call.enqueue(new Callback<MovieRetrofit>() {
            @Override
            public void onResponse(Call<MovieRetrofit> call, Response<MovieRetrofit> response) {
                if (response.body() != null) {
                    listener.bindMovies(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<MovieRetrofit> call, Throwable t) {
                listener.errorServer();
            }
        });
    }

    public void fetchTopRatedMovie() {
        Call<MovieRetrofit> call = serviceConnection.getTopRatedMovies();
        call.enqueue(new Callback<MovieRetrofit>() {
            @Override
            public void onResponse(Call<MovieRetrofit> call, Response<MovieRetrofit> response) {
                if (response.body() != null) {
                    listener.bindMovies(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<MovieRetrofit> call, Throwable t) {
                listener.errorServer();
            }
        });
    }
}
