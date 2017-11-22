package com.hitss.swiperefresh.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.hitss.swiperefresh.R;
import com.hitss.swiperefresh.app.MyApplication;
import com.hitss.swiperefresh.helper.Movie;
import com.hitss.swiperefresh.helper.SwipeListAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private String TAG = MainActivity.class.getSimpleName();
    private String URL_TOP_250 = "https://api.androidhive.info/json/imdb_top_250.php?offset=";

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private SwipeListAdapter adapter;
    private List<Movie> movieList;
    private int offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        movieList = new ArrayList<>();
        adapter = new SwipeListAdapter(this, movieList);
        listView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(this);

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                fetchMovies();
            }
        });

    }

    /**
     * Metodo llamado cuando cuando se desliza la pantalla (swipe down)
     */
    @Override
    public void onRefresh() {
        //adapter.cleanList();
        fetchMovies();
    }

    /**
     * Llamado por http del listado de peliculas
     */
    private void fetchMovies() {

        swipeRefreshLayout.setRefreshing(true);
        String url = URL_TOP_250 + offset;

        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject movieObj = response.getJSONObject(i);
                                    int rank = movieObj.getInt("rank");
                                    String title = movieObj.getString("title");
                                    Movie m = new Movie(rank, title);
                                    movieList.add(0, m);
                                    // Updating offset value to highest value
                                    if (rank >= offset)
                                        offset = rank;
                                } catch (Exception exception) {
                                    Log.e(TAG, "JSON parsing Error: " + exception.getMessage());
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                        // Parar swipe refresh
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Server Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                // Parar swipe refresh
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //Agregar el request al queue
        MyApplication.getmInstance().addToRequestQueue(request);

    }

}
