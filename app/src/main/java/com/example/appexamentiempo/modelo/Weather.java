package com.example.appexamentiempo.modelo;

import android.location.Location;

import com.google.gson.annotations.SerializedName;


public class Weather {

    @SerializedName("current")
    private Current current;

    public Current getCurrent() {
        return current;
    }

}
