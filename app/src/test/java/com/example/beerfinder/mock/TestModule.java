package com.example.beerfinder.mock;

import android.content.Context;

import com.example.beerfinder.UIModule;
import com.example.beerfinder.db.Repository;
import com.example.beerfinder.di.Network;
import com.example.beerfinder.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


public class TestModule extends UIModule {

    private Context context;


    public TestModule(Context context) {
        super(context);
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


    @Provides
    @Singleton
    public Repository databaseRepository() {
        return MockBeerRepository.mockDatabaseRepository;
    }

}
