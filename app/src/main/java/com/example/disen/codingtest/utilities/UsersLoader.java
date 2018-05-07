package com.example.disen.codingtest.utilities;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by disen on 5/6/2018.
 */

public class UsersLoader extends AsyncTaskLoader<ArrayList<Users>> {
    String request;
    public UsersLoader(Context context, String request) {
        super(context);
        this.request = request;
    }

    //making request in different thread.
    @Override
    public ArrayList<Users> loadInBackground() {
        ArrayList<Users> users = new ArrayList<>();
        try {
            users = Utils.fetchData(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
