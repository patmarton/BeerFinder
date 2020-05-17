package com.example.beerfinder.view;

import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

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
    public ListPresenter listPresenter;

    List<Beer> beers;
    List<String> nameList;

    private RecyclerView recyclerView;
    private BeerAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText editText;
    private TextView history;

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


        editText = findViewById(R.id.edittext);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });



        try {
            beers = listPresenter.getAllBeersFromApi();
            Log.d("semmi", beers.get(1).getDescription());
        } catch (IOException e) {
            e.printStackTrace();
            beers = new ArrayList<>();
        }


       nameList = listPresenter.extractName(beers);
       String[] array = nameList.toArray(new String[nameList.size()]);



        // specify an adapter (see also next example)
        mAdapter = new BeerAdapter(array);
        recyclerView.setAdapter(mAdapter);

        List<Beer> beer = listPresenter.getAllBeers();

        history = findViewById(R.id.history);
        history.setText(beer.get(beer.size()-1).getName());

    }

    private void filter(String text){
        ArrayList<String> filteredList  = new ArrayList<>();

        for(String s: nameList) {
            if (s.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(s);
            }
        }
        mAdapter.filterList(filteredList);

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
