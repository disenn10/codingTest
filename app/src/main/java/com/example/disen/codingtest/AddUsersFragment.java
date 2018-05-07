package com.example.disen.codingtest;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.disen.codingtest.databinding.FragmentAddUsersBinding;
import com.example.disen.codingtest.utilities.Utils;

import java.io.IOException;

public class AddUsersFragment extends Fragment {
    FragmentAddUsersBinding binding;

    public AddUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using binding
        binding= FragmentAddUsersBinding.inflate(inflater,container,false);
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
        return binding.getRoot();
    }

    //Add user only if all fields are filled out else prompt the user to do so
    public void addUser(){
        if(!binding.firstName.getText().toString().equals("") && !binding.lastName.getText().toString().equals("") && !binding.job.getText().toString().equals("")){
        sendRequest(binding.firstName.getText().toString(),binding.lastName.getText().toString(),binding.job.getText().toString());}
        else{
            fill_out_fields();
        }
    }

    //Add new user
    private void sendRequest(final String firstname, final String lastname, final String job) {
        class postLoader extends AsyncTask<Void, Void, Boolean> {

            @Override
            protected Boolean doInBackground(Void... voids) {
                try {
                    Utils.postData(Utils.users_request,firstname,lastname,job);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            //if successful, reset fields otherwise let the user know an error occured
            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if(aBoolean){
                    posted();
                    binding.job.setText("");
                    binding.firstName.setText("");
                    binding.lastName.setText("");}
                else{
                    error_posting();
                }
            }
        }
        postLoader sendPostReqAsyncTask = new postLoader();
        sendPostReqAsyncTask.execute();
    }
    //prompt user to fill out fields
    public void fill_out_fields(){
        Snackbar snackbar = Snackbar.make(binding.getRoot(),getString(R.string.empty),Snackbar.LENGTH_LONG);
        snackbar.show();
    }
    //show it up only if the user was not successfully added
    public void error_posting(){
        Snackbar snackbar = Snackbar.make(binding.getRoot(),getString(R.string.no_post),Snackbar.LENGTH_LONG);
        snackbar.show();
    }
    //display it, if the user was added successfully
    public void posted(){
        Snackbar snackbar = Snackbar.make(binding.getRoot(),getString(R.string.posted),Snackbar.LENGTH_LONG);
        snackbar.show();
    }
    }
