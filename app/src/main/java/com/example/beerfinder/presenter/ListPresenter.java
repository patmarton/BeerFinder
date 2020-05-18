package com.example.beerfinder.presenter;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.db.Repository;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.network.NetworkApi;
import com.example.beerfinder.network.NetworkInteractor;
import com.example.beerfinder.view.IListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import retrofit2.Call;

public class ListPresenter extends Presenter<IListView>{

    //List to collect beers
    List<Beer> beerList;

    //Inject Interactors
    @Inject
    Repository repository;

    @Inject
    NetworkInteractor networkInteractor;


    @Inject
    public ListPresenter(){
    }

    public ListPresenter(Repository repository){
        this.repository = repository;
    }



   public void persistBeer(List<Beer> beers){
        repository.insertBeers(beers);
    }

    public void deleteBeerById(Long id){
        repository.DeleteBeerById(id);
    }

    public void deleteBeer(Beer beer){
        repository.DeleteBeer(beer);
    }

    public List<Beer> getAllBeers(){
        return repository.getAllBeers();
    }

    public List<Beer> getAllBeersFromApi() throws IOException {
        return networkInteractor.getBeers();
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void attachScreen(IListView screen) {
        super.attachScreen(screen);
        BeerFinderApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public List<String> extractName(List<Beer> beers){
        List<String> names = new ArrayList<>();
        for(Beer beer : beers){
            names.add(beer.getName());
        }
        return names;
    }

}
