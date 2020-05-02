package com.example.beerfinder;

import android.app.Application;

public class BeerFinderApplication extends Application {

    public static BeerFinderApplicationComponent injector;


    @Override
    public void onCreate(){
        super.onCreate();

        injector = DaggerBeerFinderApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }


}
