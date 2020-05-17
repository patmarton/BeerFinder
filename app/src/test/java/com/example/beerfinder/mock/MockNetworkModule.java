package com.example.beerfinder.mock;

import com.example.beerfinder.network.NetworkApi;
import com.example.beerfinder.network.NetworkInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public NetworkApi provideNetworkApi(Retrofit.Builder retrofitBuilder) {
        return new MockNetworkApi();
    }

    @Provides
    @Singleton
    public NetworkInteractor provideNetworkInteractor(Retrofit.Builder retrofitBuilder) {
        return new NetworkInteractor();
    }

}
