package com.example.beerfinder.presenter;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.db.Repository;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.network.NetworkInteractor;
import com.example.beerfinder.view.IDetailsView;
import com.example.beerfinder.view.IListView;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class DetailsPresenter extends Presenter<IDetailsView>{

    @Inject
    Repository repository;

    @Inject
    NetworkInteractor networkInteractor;

    @Inject
    public DetailsPresenter(){
    }

    @Override
    public void attachScreen(IDetailsView screen) {
        super.attachScreen(screen);
        BeerFinderApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public List<Beer> getBeers() throws IOException {
        return networkInteractor.getBeers();
    }

    public Beer getBeer(List<Beer> beers, String name){
        for(Beer beer: beers) {
            if (beer.getName().equals(name)) {
                return beer;
            }
        }
        return beers.get(1);
    }

    //TODO
}
