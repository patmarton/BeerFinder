package com.example.beerfinder.mock;

import com.example.beerfinder.BeerFinderApplicationComponent;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class})
public interface TestComponent extends BeerFinderApplicationComponent {
}
