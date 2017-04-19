package com.brazina.domain.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abrazina on 4/18/17.
 */

public class SearchResult {

    @SerializedName("Search")
    private List<Movie> searchResults;

    public List<Movie> getSearchResults() {
        return searchResults;
    }
}
