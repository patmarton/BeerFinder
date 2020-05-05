package com.example.beerfinder;

import com.example.beerfinder.mock.TestModule;

public class TestApplication extends BeerFinderApplication {

    @Override
    public void onCreate(){
        super.onCreate();

        injector = DaggerBeerFinderApplicationComponent.builder().uIModule(new TestModule(this)).build();
    }

}
