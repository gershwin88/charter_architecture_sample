package com.brazina.common.controllers;

import com.brazina.common.controllers.impl.MovieListControllerImpl;

/**
 * Created by abrazina on 4/18/17.
 */

public class ControllerFactory {

    private static final ControllerFactory INSTANCE = new ControllerFactory();

    private ControllerFactory() {}

    private MovieListController movieListController;

    public static MovieListController getMovieListController() {
        ControllerFactory controllerFactory = ControllerFactory.INSTANCE;
        if (controllerFactory.movieListController == null) {
            controllerFactory.movieListController = new MovieListControllerImpl();
        }
        return controllerFactory.movieListController;
    }
}
