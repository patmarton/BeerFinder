package com.example.beerfinder.mock;

import com.example.beerfinder.BeerFinderApplicationComponent;
import com.example.beerfinder.test.DetailsTest;
import com.example.beerfinder.test.ListTest;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends BeerFinderApplicationComponent {
    void inject(ListTest listTest);
    void inject(DetailsTest detailsTest);
}
