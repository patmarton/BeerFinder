package com.example.beerfinder.presenter;

import com.example.beerfinder.db.Repository;
import com.example.beerfinder.view.IDetailsView;
import com.example.beerfinder.view.IListView;

import javax.inject.Inject;

public class DetailsPresenter extends Presenter<IDetailsView>{

    @Inject
    Repository repository;

    //TODO
}
