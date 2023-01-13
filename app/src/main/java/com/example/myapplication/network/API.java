package com.example.myapplication.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API {
    @Headers({"X-RapidAPI-Key: 46631d2f03msh9ddc6094d46437ep1015bajsnc0291db43202", "X-RapidAPI-Host: football98.p.rapidapi.com"})
    @GET("/premierleague/table")
    Call<List<TeamModel>> getTeams();

    @Headers({"X-RapidAPI-Key: 46631d2f03msh9ddc6094d46437ep1015bajsnc0291db43202", "X-RapidAPI-Host: football98.p.rapidapi.com"})
    @GET("/competitions")
    Call<List<String>> getCompetitions();
}
