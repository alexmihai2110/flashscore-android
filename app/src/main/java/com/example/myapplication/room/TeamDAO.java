package com.example.myapplication.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TeamDAO {

    @Query("SELECT * FROM teams")
    List<Team> getAll();

    @Insert
    void insertAllData(Team team);
}
