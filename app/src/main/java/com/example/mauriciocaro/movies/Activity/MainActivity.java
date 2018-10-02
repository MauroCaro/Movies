package com.example.mauriciocaro.movies.Activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mauriciocaro.movies.Adapter.MovieAdapter;
import com.example.mauriciocaro.movies.Data.MovieData;
import com.example.mauriciocaro.movies.Model.MovieModel;
import com.example.mauriciocaro.movies.R;

import java.util.List;

/**
 * Activity to show the grid of the movies
 *
 * @author mauricio.caro
 */
public class MainActivity extends AppCompatActivity implements MainActivityView {

    private RecyclerView recyclerMovie;
    private ProgressBar progressBar;
    private MovieData movieData;
    private MovieAdapter movieAdapter;
    private boolean isPopularChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerMovie = findViewById(R.id.recycler_movies);
        progressBar = findViewById(R.id.progress_movies);
        movieData = new MovieData(this);
        movieData.fetchPopularMovie();
    }

    @Override
    public void bindMovies(List<MovieModel> modelList) {
        recyclerMovie.setLayoutManager(new GridLayoutManager(this, 3));
        movieAdapter = new MovieAdapter(modelList);
        recyclerMovie.setAdapter(movieAdapter);
        showProgress(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_popular:
                if (!item.isChecked()) {
                    cleanView();
                    movieData.fetchPopularMovie();
                    item.setChecked(true);
                    isPopularChecked = true;
                }
                return true;
            case R.id.menu_top_rated:
                if (!item.isChecked()) {
                    cleanView();
                    movieData.fetchTopRatedMovie();
                    item.setChecked(true);
                    isPopularChecked = false;
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void errorServer() {
        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.relative), R.string.error_message, Snackbar.LENGTH_LONG)
                .setAction(R.string.action_retry, view -> {
                    showProgress(true);
                    if (isPopularChecked) movieData.fetchPopularMovie();
                    else movieData.fetchTopRatedMovie();
                }).setDuration(Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
        showProgress(false);
    }

    private void showProgress(boolean show) {
        if (show) progressBar.setVisibility(View.VISIBLE);
        else progressBar.setVisibility(View.INVISIBLE);
    }

    private void cleanView() {
        recyclerMovie.removeAllViewsInLayout();
        showProgress(true);
    }
}
