package com.example.disen.codingtest.utilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by disen on 5/6/2018.
 */

public class Utils {

    public static String users_request = "https://reqres.in/api/users";

    //get list of users based on the url request
    public static ArrayList<Users> fetchData(String request) throws IOException {
        ArrayList<Users> user = new ArrayList<>();
        URL url = createUrl(request);
        String output = makeHttpRequest(url);
        try {
            user = ExtractData(output);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

    //create url, then make request by calling posthttprequest function
    public static void postData(String request,String first_name, String last_name, String job) throws IOException {
        URL url = createUrl(request);
        postHttpRequest(url,first_name,last_name,job);
    }
    //converts string to url
    public static URL createUrl(String request){
        URL url = null;
        try {
            url = new URL(request);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    //POST
    public static void postHttpRequest(URL url,String first_name,String last_name,String job) throws IOException {
        // Create data variable to send values to server
        String data = URLEncoder.encode("name", "UTF-8")
                + "=" + URLEncoder.encode(first_name+" "+last_name, "UTF-8");

        data += "&" + URLEncoder.encode("job", "UTF-8") + "="
                + URLEncoder.encode(job, "UTF-8");
        BufferedWriter writer = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Key","Value");

        OutputStream outputPost = new BufferedOutputStream(connection.getOutputStream());
        writer = new BufferedWriter (new OutputStreamWriter(outputPost, "UTF-8"));
        writer.write(data);
        outputPost.flush();
        outputPost.close();
        
    }

    //GET
    public static String makeHttpRequest(URL url) throws IOException {
        InputStream in = null;
        String output = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(10000);
        if(connection.getResponseCode()==200){
            in = connection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            if(scanner.hasNext()){
                output =  scanner.next();
            }
            else {
                return null;
            }
            connection.disconnect();
        }
        return output;
    }

    //Retrieve users from Json object
    public static ArrayList<Users> ExtractData(String output) throws JSONException {
        int id = 0;
        String first_name = "";
        String last_name = "";
        String avatar = "";
        ArrayList<Users> new_user = new ArrayList<>();
        JSONObject requestObject = new JSONObject(output);
        JSONArray data = requestObject.getJSONArray("data");
        int size = data.length();
        for (int i =0;i<size;i++){
            JSONObject users = data.getJSONObject(i);
            if(users.has("id")){
                id = users.getInt("id");
            }
            if(users.has("first_name")){
                first_name = users.getString("first_name");
            }
            if(users.has("last_name")){
                last_name = users.getString("last_name");
            }
            if(users.has("avatar")){
                avatar = users.getString("avatar");
            }
            new_user.add(new Users(id,first_name,last_name,avatar));
        }
        return new_user;
    }


}
