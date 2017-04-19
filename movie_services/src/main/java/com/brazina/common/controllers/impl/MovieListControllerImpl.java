package com.brazina.common.controllers.impl;

import com.brazina.common.controllers.MovieListController;
import com.brazina.common.presentation.MovieListPresentationData;
import com.brazina.common.presentation.PresentionFactory;
import com.brazina.domain.models.SearchResult;
import com.brazina.domain.services.ServiceController;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by abrazina on 4/18/17.
 */

public class MovieListControllerImpl implements MovieListController {

    private Subscription requestSubscription;

    @Override
    public void fetchMovieList() {
        if (requestSubscription != null && !requestSubscription.isUnsubscribed()) {
            return;
        }

        Map<String, String> searchParams = new HashMap<>();
        searchParams.put("s", "doctor");
        searchParams.put("type", "movie");

        requestSubscription = ServiceController.newMovieService()
                .fetchMovieResults(searchParams)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(new Subscriber<SearchResult>() {
                    @Override
                    public void onCompleted() {
                        // Called when request is complete
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Called when an error occurs
                    }

                    @Override
                    public void onNext(SearchResult searchResult) {
                        // Called when a value is returned

                        MovieListPresentationData presentationData = PresentionFactory.getMovieListPresentationData();

                        presentationData.setMovieList(searchResult.getSearchResults());
                        presentationData.getMovieListPublishSubject().onNext(null);
                    }
                });
    }
}
