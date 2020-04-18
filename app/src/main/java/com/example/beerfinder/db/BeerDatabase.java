package com.example.beerfinder.db;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import com.example.beerfinder.model.Beer;

@Database(entities = Beer.class, version = 1, exportSchema = false)
public abstract class BeerDatabase extends RoomDatabase {
    public abstract BeerDao dao();
}