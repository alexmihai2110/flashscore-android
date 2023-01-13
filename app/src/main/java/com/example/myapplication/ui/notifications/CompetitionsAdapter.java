package com.example.myapplication.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsViewHolder> {

    Context context;
    List<String> items;

    public CompetitionsAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CompetitionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CompetitionsViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_notifications,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionsViewHolder holder, int position) {
        holder.nameView.setText(items.get(position));
    }



    @Override
    public int getItemCount() {
        return items.size();
    }
}

