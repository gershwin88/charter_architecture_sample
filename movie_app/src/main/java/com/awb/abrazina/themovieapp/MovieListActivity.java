package com.awb.abrazina.themovieapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.brazina.common.controllers.ControllerFactory;
import com.brazina.common.presentation.PresentionFactory;

import rx.Subscriber;
import rx.Subscription;

public class MovieListActivity extends AppCompatActivity {

    private Subscription movieListRefreshSubscription;

    private Button moviesButton;
    private RecyclerView movieListRecylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        movieListRecylerView = (RecyclerView) findViewById(R.id.movies_list);

        moviesButton = (Button) findViewById(R.id.load_movies_button);
        moviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControllerFactory.getMovieListController().fetchMovieList();
            }
        });

        movieListRefreshSubscription = PresentionFactory.getMovieListPresentationData().getMovieListPublishSubject().subscribe(new Subscriber<Void>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Void aVoid) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        moviesButton.setVisibility(View.GONE);
                        movieListRecylerView.setVisibility(View.VISIBLE);
                        movieListRecylerView.setAdapter(new MovieListAdapter(PresentionFactory.getMovieListPresentationData().getMovieList()));
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (movieListRefreshSubscription != null) {
            movieListRefreshSubscription.unsubscribe();
        }
    }
}
