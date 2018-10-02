package com.example.mauriciocaro.movies.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mauriciocaro.movies.Model.MovieModel;
import com.example.mauriciocaro.movies.R;
import com.example.mauriciocaro.movies.Util.Constant;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Activity to show the detail of the movie
 *
 * @author mauricio.caro
 */
public class MovieDetailActivity extends AppCompatActivity {

    public static final String ARG_MOVIE_DETAIL = "movieDetail";

    private MovieModel movieModel;
    private ImageView detailImageView;
    private net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressBar detailProgressBar;
    private TextView detailDescriptionTextView;
    private TextView detailVoteAverageTextView;
    private TextView detailReleaseDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        detailImageView = findViewById(R.id.detail_image);
        detailProgressBar = findViewById(R.id.detail_progress_image);
        detailDescriptionTextView = findViewById(R.id.detail_description);
        detailVoteAverageTextView = findViewById(R.id.detail_vote_average);
        detailReleaseDateTextView = findViewById(R.id.detail_release_date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        movieModel = getIntent().hasExtra(ARG_MOVIE_DETAIL) ? (MovieModel) getIntent().getSerializableExtra(ARG_MOVIE_DETAIL) : null;
        bindView();
    }

    private void bindView() {
        collapsingToolbarLayout.setTitle(movieModel.getTitle());
        detailDescriptionTextView.setText(movieModel.getOverview());
        detailVoteAverageTextView.setText(String.valueOf(movieModel.getVoteAverage()));
        detailReleaseDateTextView.setText(movieModel.getReleaseDate());
        Picasso.with(this).load(Constant.URL_IMAGES_LARGE + movieModel.getUrlBackdropImage()).into(detailImageView, new Callback() {
            @Override
            public void onSuccess() {
                detailProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                detailProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
