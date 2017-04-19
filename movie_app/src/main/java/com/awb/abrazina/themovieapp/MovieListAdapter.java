package com.awb.abrazina.themovieapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brazina.domain.models.Movie;

import java.util.List;

/**
 * Created by abrazina on 4/18/17.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private List<Movie> movieList;

    public MovieListAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.populate(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView yearTextView;

        MovieViewHolder(View view) {
            super(view);

            titleTextView = (TextView) view.findViewById(R.id.title_text);
            yearTextView = (TextView) view.findViewById(R.id.year_text);
        }

        void populate(Movie movie) {
            titleTextView.setText(movie.getTitle());
            yearTextView.setText(movie.getYear());
        }
    }
}
