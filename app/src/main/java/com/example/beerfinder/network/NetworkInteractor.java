package com.example.beerfinder.network;

import com.example.beerfinder.model.Beer;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class NetworkInteractor {

    @Inject
    NetworkApi networkApi;

    @Inject
    public NetworkInteractor(){

    }

    public List<Beer> getBeers() throws IOException {
        Call<List<Beer>> beerCall = networkApi.listBeers();
        return beerCall.execute().body();
    }
}
