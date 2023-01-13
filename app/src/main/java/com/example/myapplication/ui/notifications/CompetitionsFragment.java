package com.example.myapplication.ui.notifications;

import static com.example.myapplication.network.APIService.getClient;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.network.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CompetitionsFragment extends Fragment {
    private RecyclerView recyclerView;
    private Retrofit api;
    private API apiService;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
      View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
      api = getClient();
      recyclerView = view.findViewById(R.id.recyclerview);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
      GetTeamModels(getContext());
      return view;
    }

    private void GetTeamModels(Context context){
        apiService = api.create(API.class);
        Call<List<String>> call = apiService.getCompetitions();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> competitions = response.body();
                recyclerView.setAdapter(new CompetitionsAdapter(context, competitions));
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }
}
