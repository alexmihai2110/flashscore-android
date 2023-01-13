package com.example.myapplication.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Team.class}, version = 1)
public abstract class TeamDatabase extends RoomDatabase {
    public abstract TeamDAO teamDAO();

    public static TeamDatabase INSTANCE;
    public static TeamDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (TeamDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,
                            TeamDatabase.class, "database-name").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
