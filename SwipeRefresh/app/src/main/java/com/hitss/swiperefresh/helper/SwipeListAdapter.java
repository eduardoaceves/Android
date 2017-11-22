package com.hitss.swiperefresh.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hitss.swiperefresh.R;

import java.util.List;

/**
 * Created by Hitss on 21/11/2017.
 * adaptador para swipe layout view
 */

public class SwipeListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> movieList;
    private String[] bgColors;

    public SwipeListAdapter(Activity activity, List<Movie> movieList) {
        this.activity = activity;
        this.movieList = movieList;
        bgColors = activity.getApplicationContext().getResources().getStringArray(R.array.movie_serial_bg);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = inflater.inflate(R.layout.list_row, null);

        TextView serial = (TextView) view.findViewById(R.id.serial);
        TextView title = (TextView) view.findViewById(R.id.title);

        serial.setText(String.valueOf(movieList.get(position).id));
        title.setText(String.valueOf(movieList.get(position).title));

        String color = bgColors[position % bgColors.length];
        serial.setBackgroundColor(Color.parseColor(color));

        return view;
    }


    public void cleanList(){
        movieList.clear();
        notifyDataSetChanged();
    }

}
