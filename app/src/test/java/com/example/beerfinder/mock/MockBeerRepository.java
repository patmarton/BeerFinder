package com.example.beerfinder.mock;

import com.example.beerfinder.db.Repository;
import com.example.beerfinder.model.Beer;

import java.util.List;

public class MockBeerRepository extends Repository {

    @Override
    public void insertBeers(List<Beer> beers) {
        super.insertBeers(beers);
    }

    @Override
    public List<Beer> getAllBeers() {
        return super.getAllBeers();
    }

    @Override
    public Beer getBeerById(Long beerId) {
        return super.getBeerById(beerId);
    }

    @Override
    public void DeleteBeer(Beer beer) {
        super.DeleteBeer(beer);
    }

    @Override
    public void DeleteBookById(Long beerId) {
        super.DeleteBookById(beerId);
    }
}
