package com.example.myapplication.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompetitionModel {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public CompetitionModel(String name) {
        Name = name;
    }

    @SerializedName("Name")
    @Expose
    private String Name;
}
