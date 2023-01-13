package com.example.myapplication.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teams")
public class Team {
    @PrimaryKey
    @ColumnInfo(name = "position")
    public int position;

    @ColumnInfo(name = "name")
    public String name;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team(int position, String name) {
        this.position = position;
        this.name = name;
    }
}
