package com.example.beerfinder.presenter;

import com.example.beerfinder.db.Repository;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.network.NetworkApi;
import com.example.beerfinder.view.IListView;

import java.util.List;

import javax.inject.Inject;

public class ListPresenter extends Presenter<IListView>{

    //List to collect beers
    List<Beer> beerList;

    //Inject Interactors
    @Inject
    Repository repository;

    @Inject
    NetworkApi networkApi;

    //TODO
}
