package com.example.beerfinder.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.R;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.presenter.DetailsPresenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.crashlytics.android.Crashlytics;

public class DetailsActivity extends AppCompatActivity implements IDetailsView {

    @Inject
    DetailsPresenter detailsPresenter;

    String data;

    List<Beer> beers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BeerFinderApplication.injector.inject(this);

        TextView tv1 = (TextView) findViewById(R.id.text_view1);
        TextView tv2 = (TextView) findViewById(R.id.text_view2);
        TextView tv3 = (TextView) findViewById(R.id.text_view3);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
             data = extras.getString("name");

        try {
            beers = detailsPresenter.getBeers();
        } catch (IOException e) {
            e.printStackTrace();
            beers = new ArrayList<>();
        }

        Beer b = detailsPresenter.getBeer(beers,data);

        tv1.setText(b.getName());
        tv2.setText(b.getDescription());
        tv3.setText(b.getTagline());

        List<Beer> list = new ArrayList<>();
        list.add(b);

        detailsPresenter.persistBeer(list);

       // Crashlytics.getInstance().crash();


    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //TODO
}
