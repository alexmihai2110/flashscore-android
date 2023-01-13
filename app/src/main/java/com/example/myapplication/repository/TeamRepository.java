package com.example.myapplication.repository;

import static com.example.myapplication.network.APIService.getClient;

import android.content.Context;

import com.example.myapplication.network.API;
import com.example.myapplication.network.TeamModel;
import com.example.myapplication.room.Team;
import com.example.myapplication.room.TeamDAO;
import com.example.myapplication.room.TeamDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TeamRepository {
    TeamDAO teamDAO;
    private Retrofit retrofit;
    API api;


    public TeamRepository(Context context){
        TeamDatabase teamDatabase = TeamDatabase.getDatabase(context);
        teamDAO = teamDatabase.teamDAO();
        retrofit = getClient();
    }

    public List<Team> getAll(){
        List<Team> teamsDao = teamDAO.getAll();
        if(teamDAO.getAll().size() != 0) {
            return teamDAO.getAll();
        }
        api = retrofit.create(API.class);
        Call<List<TeamModel>> call = api.getTeams();
        List<Team> teamsDB = new ArrayList<Team>();
        call.enqueue(new Callback<List<TeamModel>>() {
            @Override
            public void onResponse(Call<List<TeamModel>> call, Response<List<TeamModel>> response) {
                List<TeamModel> teams = response.body();

                for (TeamModel team : teams)
                {
                    Team teamDB = new Team(team.getPosition(), team.getName());
                    teamDAO.insertAllData(teamDB);
                    teamsDB.add(teamDB);

                }
            }

            @Override
            public void onFailure(Call<List<TeamModel>> call, Throwable t) {

            }
        });
        return teamsDB;
    }
}
