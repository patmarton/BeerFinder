package com.example.beerfinder.network;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public static final String ENDPOINT_ADDRESS= "https://api.punkapi.com/v2/";

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public NetworkApi provideNetworkApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(ENDPOINT_ADDRESS).build().create(NetworkApi.class);
    }
}
