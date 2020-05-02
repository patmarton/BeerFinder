package com.example.beerfinder.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.model.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

public class Repository {

    @Inject
    Context context;

    private BeerDatabase beerDatabase;

    public Repository(){
        BeerFinderApplication.injector.inject(this);
        beerDatabase = Room.databaseBuilder(context, BeerDatabase.class,"beerdb").build();
    }


    //TODO
    //insert, getAll, getById, delete
    public void insertBeers(final List<Beer> beers){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                for (Beer beer : beers)
                    beerDatabase.dao().insertBeer(beer);
                return null;
            }
        }.execute();
    }

    public List<Beer> getAllBeers(){
        try {
            return new AsyncTask<Void, Void, List<Beer>>() {
                @Override
                protected List<Beer> doInBackground(Void... voids) {
                    return beerDatabase.dao().getAllBeers();
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Beer getBeerById(Long beerId){
        try {
            return new AsyncTask<Void, Void, Beer>() {
                @Override
                protected Beer doInBackground(Void... voids) {
                    return beerDatabase.dao().getBeerById(beerId);
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void DeleteBeer(final Beer beer){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                beerDatabase.dao().deleteBeer(beer);
                return null;
            }
        }.execute();
    }

    public void DeleteBookById(final Long beerId){
        final Beer beer = getBeerById(beerId);
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                beerDatabase.dao().deleteBeer(beer);
                return null;
            }
        }.execute();
    }
}
