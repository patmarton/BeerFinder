package com.example.beerfinder.view;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.R;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.presenter.ListPresenter;
import com.example.beerfinder.adapter.BeerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ListActivity extends AppCompatActivity implements IListView{

    @Inject
    ListPresenter listPresenter;

    List<Beer> beers;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void showBeers(String s) {
        //TODO
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_list);
        BeerFinderApplication.injector.inject(this);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String[] data = new String[10];
        data[0] = "Soproni IPA";
        data[1] = "Mad Scientist Valgull";
        data[2] = "Mad Scientist NeIPA";
        data[3] = "Monyo Rabbit";
        data[4] = "Borsodi Nitro";



        try {
            beers = listPresenter.getAllBeersFromApi();
            Log.d("semmi", beers.get(1).getDescription());
        } catch (IOException e) {
            e.printStackTrace();
            beers = new ArrayList<>();
        }

        List<String> list = new ArrayList<>();

        for(Beer beer: beers){
            list.add(beer.getTagline());
        }

        String[] array = list.toArray(new String[list.size()]);



        // specify an adapter (see also next example)
        mAdapter = new BeerAdapter(array);
        recyclerView.setAdapter(mAdapter);
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
