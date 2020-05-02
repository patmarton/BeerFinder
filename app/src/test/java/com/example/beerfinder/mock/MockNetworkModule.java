package com.example.beerfinder.mock;

import com.example.beerfinder.network.NetworkApi;

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
    public NetworkApi provideArtistsApi(Retrofit.Builder retrofitBuilder) {
        return new MockNetworkApi();
    }

}
