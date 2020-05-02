package com.example.beerfinder.mock;

import com.example.beerfinder.model.Beer;
import com.example.beerfinder.network.NetworkApi;

import java.util.List;

import retrofit2.Call;

public class MockNetworkApi implements NetworkApi {
    @Override
    public Call<List<Beer>> listBeers() {
        return null;
    }
}
