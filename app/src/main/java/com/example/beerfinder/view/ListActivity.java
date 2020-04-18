package com.example.beerfinder.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.R;
import com.example.beerfinder.presenter.ListPresenter;

import javax.inject.Inject;

public class ListActivity extends AppCompatActivity implements IListView{

    @Inject
    ListPresenter listPresenter;

    @Override
    public void showBeers(String s) {
        //TODO
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_list);
        BeerFinderApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);
    }

    @Override
    protected void onStop(){
        super.onStop();
        listPresenter.detachScreen();
    }
}
