package com.example.mauriciocaro.movies.Activity;

import com.example.mauriciocaro.movies.Model.MovieModel;

import java.util.List;

public interface MainActivityView {

    void bindMovies(List<MovieModel> modelList);
}
