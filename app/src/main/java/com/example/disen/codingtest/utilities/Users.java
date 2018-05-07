package com.example.disen.codingtest.utilities;

/**
 * Created by disen on 5/6/2018.
 */

public class Users {
    int id;
    String first_name;
    String last_name;
    String avatar;
    public Users(int id, String first_name, String last_name, String avatar){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
