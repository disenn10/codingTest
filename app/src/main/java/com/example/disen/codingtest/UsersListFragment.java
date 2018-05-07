package com.example.disen.codingtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.disen.codingtest.R;
import com.example.disen.codingtest.utilities.Users;
import com.example.disen.codingtest.utilities.UsersAdapter;
import com.example.disen.codingtest.utilities.UsersLoader;
import com.example.disen.codingtest.utilities.Utils;

import java.util.ArrayList;

public class UsersListFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<Users>>{
    RecyclerView recyclerview;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_users_list, container, false);
        recyclerview = view.findViewById(R.id.users_recyclv);
        getLoaderManager().initLoader(0,null,this);
        return view;
    }

    @Override
    public Loader<ArrayList<Users>> onCreateLoader(int id, Bundle args) {
        return new UsersLoader(getContext(), Utils.users_request);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Users>> loader, ArrayList<Users> data) {
        //call updateUI if any data was returned
        if(data!=null){
            updateUI(data);
        }

    }
    //fill out the UI with new elements retrieved from the server
    private void updateUI(ArrayList<Users> data) {
        UsersAdapter userAdapter = new UsersAdapter(getContext(),data);
        LinearLayoutManager lmgr = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(lmgr);
        recyclerview.setAdapter(userAdapter);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Users>> loader) {
        loader.reset();
    }
}
