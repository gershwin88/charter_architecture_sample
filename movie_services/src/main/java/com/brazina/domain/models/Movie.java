package com.brazina.domain.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abrazina on 4/18/17.
 */

public class Movie {

    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    private String imdbID;

    @SerializedName("Type")
    private String type;

    @SerializedName("Poster")
    private String posertUrl;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
