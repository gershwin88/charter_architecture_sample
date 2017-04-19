package com.brazina.domain.services;

import com.brazina.domain.models.SearchResult;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by abrazina on 4/18/17.
 */

public interface MovieService {

    @GET ("/")
    Observable<SearchResult> fetchMovieResults(@QueryMap Map<String, String> params);
}
