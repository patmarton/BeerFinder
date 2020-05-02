package com.example.beerfinder.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import com.example.beerfinder.model.Beer;

import java.util.List;

@Dao
public interface BeerDao {

    @Insert
    Long insertBeer(Beer beer);

    @Query("SELECT * FROM Beer")
    List<Beer> getAllBeers();

    @Query("SELECT * FROM Beer WHERE beerId = :beerId")
    Beer getBeerById(Long beerId);

    @Delete
    void deleteBeer(Beer beer);

}
