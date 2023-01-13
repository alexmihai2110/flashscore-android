package com.example.myapplication.ui.dashboard;

import static com.example.myapplication.network.APIService.getClient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.network.API;
import com.example.myapplication.repository.TeamRepository;

import retrofit2.Retrofit;

public class DashboardFragment extends Fragment {
    private RecyclerView recyclerView;
    private Retrofit api;
    private API apiService;
    private TeamRepository teamRepository;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
      View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
      api = getClient();
      teamRepository = new TeamRepository(view.getContext());
      recyclerView = view.findViewById(R.id.recyclerview);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
      recyclerView.setAdapter(new MyAdapter(getContext(), teamRepository.getAll()));
      return view;
    }

}
