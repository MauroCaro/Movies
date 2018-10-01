package com.example.mauriciocaro.movies.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mauriciocaro.movies.Model.MovieModel;
import com.example.mauriciocaro.movies.R;
import com.example.mauriciocaro.movies.Util.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<MovieModel> movieModelList;

    public MovieAdapter(List<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movieModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private final ImageView poster;
        private final TextView title;

        public MovieViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_movie, parent, false));
            poster = itemView.findViewById(R.id.movie_poster);
            title = itemView.findViewById(R.id.movie_title);
        }

        public void bind(MovieModel movieModel) {
            Picasso.with(itemView.getContext()).load(Constant.URL_IMAGES + movieModel.getUrlPosterImage()).into(poster);
            title.setText(movieModel.getTitle());
        }


    }
}
