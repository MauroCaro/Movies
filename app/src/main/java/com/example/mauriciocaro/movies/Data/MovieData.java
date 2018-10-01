package com.example.mauriciocaro.movies.Data;

import android.util.Log;
import com.example.mauriciocaro.movies.Activity.MainActivityView;
import com.example.mauriciocaro.movies.Model.MovieRetrofit;
import com.example.mauriciocaro.movies.Network.Connection;
import com.example.mauriciocaro.movies.Network.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                listener.bindMovies(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieRetrofit> call, Throwable t) {
                Log.e("Error", "Error getting popular movie list from server.");
            }
        });
    }

    public void fetchTopRatedMovie() {
        Call<MovieRetrofit> call = serviceConnection.getTopRatedMovies();
        call.enqueue(new Callback<MovieRetrofit>() {
            @Override
            public void onResponse(Call<MovieRetrofit> call, Response<MovieRetrofit> response) {
                listener.bindMovies(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieRetrofit> call, Throwable t) {
                Log.e("Error", "Error getting top rated movie list from server.");
            }
        });
    }
}
