package com.example.myapplication.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamModel {
    @SerializedName("Position")
    @Expose
    private int Position;

    @SerializedName("SquadLogo")
    @Expose
    private String SquadLogo;

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public String getSquadLogo() {
        return SquadLogo;
    }

    public void setSquadLogo(String squadLogo) {
        SquadLogo = squadLogo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @SerializedName("Name")
    @Expose
    private String Name;


    public TeamModel(int position, String squadLogo, String name) {
        Position = position;
        SquadLogo = squadLogo;
        Name = name;
    }

}
