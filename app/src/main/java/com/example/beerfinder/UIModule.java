package com.example.beerfinder;

import android.content.Context;

import com.example.beerfinder.db.Repository;
import com.example.beerfinder.di.Network;
import com.example.beerfinder.network.NetworkApi;
import com.example.beerfinder.presenter.DetailsPresenter;
import com.example.beerfinder.presenter.ListPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class UIModule {

    private Context context;

    public UIModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }

   /* @Provides
    @Singleton
    public ListPresenter provideListPresenter(){ return new ListPresenter(); }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter(){
        return new DetailsPresenter();
    }


    @Provides
    @Singleton
    public Repository databaseRepository(){
        return new Repository();
    }
*/
}

