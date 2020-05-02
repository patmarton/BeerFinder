package com.example.beerfinder.network;

import android.os.Build;
import androidx.annotation.RequiresApi;

import com.example.beerfinder.model.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface NetworkApi {
/*
    //use NetworkModule instead
    static NetworkApi build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/v2/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return retrofit.create(NetworkApi.class);
    }*/

    @GET("beers?beer_name=IPA")
    Call<List<Beer>> listBeers();
}
