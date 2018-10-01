package com.example.mauriciocaro.movies.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MovieModel implements Serializable {

    @SerializedName("id")
    private int movieId;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("video")
    private boolean hasVideo;

    @SerializedName("adult")
    private boolean isAdult;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String urlPosterImage;

    @SerializedName("backdrop_path")
    private String urlBackdropImage;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    public MovieModel(Builder builder) {
        this.movieId = builder.movieId;
        this.voteCount = builder.voteCount;
        this.hasVideo = builder.hasVideo;
        this.isAdult = builder.isAdult;
        this.popularity = builder.popularity;
        this.voteAverage = builder.voteAverage;
        this.title = builder.title;
        this.urlPosterImage = builder.urlPosterImage;
        this.urlBackdropImage = builder.urlBackdropImage;
        this.originalLanguage = builder.originalLanguage;
        this.originalTitle = builder.originalTitle;
        this.overview = builder.overview;
        this.releaseDate = builder.releaseDate;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlPosterImage() {
        return urlPosterImage;
    }

    public String getUrlBackdropImage() {
        return urlBackdropImage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public static final class Builder {
        private int movieId;
        private int voteCount;
        private boolean hasVideo;
        private boolean isAdult;
        private double popularity;
        private double voteAverage;
        private String title;
        private String urlPosterImage;
        private String urlBackdropImage;
        private String originalLanguage;
        private String originalTitle;
        private String overview;
        private String releaseDate;

        public Builder setMovieId(int movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder setVoteCount(int voteCount) {
            this.voteCount = voteCount;
            return this;
        }

        public Builder setHasVideo(boolean hasVideo) {
            this.hasVideo = hasVideo;
            return this;
        }

        public Builder setAdult(boolean adult) {
            isAdult = adult;
            return this;
        }

        public Builder setPopularity(double popularity) {
            this.popularity = popularity;
            return this;
        }

        public Builder setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setUrlPosterImage(String urlPosterImage) {
            this.urlPosterImage = urlPosterImage;
            return this;
        }

        public Builder setUrlBackdropImage(String urlBackdropImage) {
            this.urlBackdropImage = urlBackdropImage;
            return this;
        }

        public Builder setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
            return this;
        }

        public Builder setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public Builder setOverview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieModel build() {
            return new MovieModel(this);
        }
    }
}
