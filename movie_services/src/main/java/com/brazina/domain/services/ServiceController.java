package com.brazina.domain.services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abrazina on 4/18/17.
 */

public class ServiceController {

    private static final ServiceController INSTANCE = new ServiceController();

    private ServiceController() {}

    private Retrofit generateRetrofit() {

        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("http://www.omdbapi.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MovieService newMovieService() {
        return ServiceController.INSTANCE.generateRetrofit().create(MovieService.class);
    }

}
