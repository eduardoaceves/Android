package com.eaa.carrousel.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eaa.carrousel.R;
import com.eaa.carrousel.model.Movie;
import com.eaa.carrousel.model.MovieResponse;
import com.eaa.carrousel.tools.Tools;
import com.eaa.carrousel.view.adapters.MainAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvCarrousel)
    RecyclerView Carrousel;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadMovieList();

        MainAdapter adapterLisMenu = new MainAdapter(movieList, MainActivity.this);
        //LinearLayoutManager manager = new LinearLayoutManager(this);
        LinearLayoutManager manager  = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        Carrousel.setLayoutManager(manager);
        Carrousel.swapAdapter(adapterLisMenu, true);
    }

    private void loadMovieList() {
        Gson gson = new Gson();
        MovieResponse movieResponse = gson.fromJson(Tools.loadMovieJson(MainActivity.this), MovieResponse.class);
        movieList = movieResponse.getResults();
    }

}
