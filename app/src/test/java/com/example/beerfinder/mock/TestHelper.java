package com.example.beerfinder.mock;

import com.example.beerfinder.BeerFinderApplication;
import com.example.beerfinder.BeerFinderApplicationComponent;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    /*public static DaggerTestComponent setTestInjector() {
        ShadowLog.stream = System.out;
        BeerFinderApplication application = (BeerFinderApplication) RuntimeEnvironment.application;
        BeerFinderApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
        return (DaggerTestComponent) injector;
    }*/
}
