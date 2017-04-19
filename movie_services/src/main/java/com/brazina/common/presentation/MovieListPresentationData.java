package com.brazina.common.presentation;

import com.brazina.domain.models.Movie;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by abrazina on 4/18/17.
 */

public class MovieListPresentationData {

    private PublishSubject<Void> movieListPublishSubject = PublishSubject.create();

    private List<Movie> movieList;

    public PublishSubject<Void> getMovieListPublishSubject() {
        return movieListPublishSubject;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
