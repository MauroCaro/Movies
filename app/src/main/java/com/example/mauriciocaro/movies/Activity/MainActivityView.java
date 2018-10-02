package com.example.mauriciocaro.movies.Activity;

import com.example.mauriciocaro.movies.Model.MovieModel;

import java.util.List;

/**
 * Interface to fire method in the view
 *
 * @author mauricio.caro
 */
public interface MainActivityView {

    void bindMovies(List<MovieModel> modelList);

    void errorServer();
}
