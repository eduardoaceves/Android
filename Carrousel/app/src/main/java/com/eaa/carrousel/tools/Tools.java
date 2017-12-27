package com.eaa.carrousel.tools;

import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Hitss on 22/12/2017.
 */

public class Tools {

    public static String loadMovieJson(Activity activity) {
        String json = null;
        try {
            InputStream inputStream = activity.getAssets().open("MovieDataBase.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


}
