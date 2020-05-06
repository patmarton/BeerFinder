package com.example.beerfinder.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.R;
import com.example.beerfinder.presenter.DetailsPresenter;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements IDetailsView {

    @Inject
    DetailsPresenter detailsPresenter;

    String data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BeerFinderApplication.injector.inject(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
             data = extras.getString("name");

        Log.d("TETETETETETTETETETE",data);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //TODO
}
