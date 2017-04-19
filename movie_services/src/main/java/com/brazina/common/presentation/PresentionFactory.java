package com.brazina.common.presentation;


/**
 * Created by abrazina on 4/18/17.
 */

public class PresentionFactory {

    private static final PresentionFactory INSTANCE = new PresentionFactory();

    private MovieListPresentationData movieListPresentationData;

    public static MovieListPresentationData getMovieListPresentationData() {
        PresentionFactory presentionFactory = PresentionFactory.INSTANCE;
        if (presentionFactory.movieListPresentationData == null) {
            presentionFactory.movieListPresentationData = new MovieListPresentationData();
        }
        return presentionFactory.movieListPresentationData;
    }
}
