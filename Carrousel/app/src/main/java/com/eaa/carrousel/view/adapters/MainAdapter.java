package com.eaa.carrousel.view.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eaa.carrousel.R;
import com.eaa.carrousel.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hitss on 22/12/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private static String MovieDBImagePath = "https://image.tmdb.org/t/p/w500";
    // https://image.tmdb.org/t/p/w500//xq1Ugd62d23K2knRUx6xxuALTZB.jpg
    private List<Movie> movieList;
    private Activity activity;

    public MainAdapter(List<Movie> movieList, Activity activity) {
        this.movieList = movieList;
        this.activity = activity;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_carrousel_item, parent, false);
        return new MainHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {

        //String img = MovieDBImagePath + movieList.get(position).getPoster_path();
        final int p = position;
        Picasso.with(activity).load(MovieDBImagePath + movieList.get(position).getPoster_path()).into(holder.poster);
        Picasso.with(activity).load(MovieDBImagePath + movieList.get(position).getPoster_path()).placeholder(R.drawable.placeholder).into(holder.poster, new Callback() {
            @Override
            public void onSuccess() {
                Log.e("Carrousel", "Image loaded -> " + p + " success!!");
            }

            @Override
            public void onError() {
                Log.e("Carrousel", "Image loaded -> " + p + " error!!");
            }
        });
    }

    @Override
    public int getItemCount() {
        if (movieList != null)
            return movieList.size();
        else
            return 0;
    }

    public static class MainHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.carrousel_poster)
        public ImageView poster;
        public int position;

        public MainHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
