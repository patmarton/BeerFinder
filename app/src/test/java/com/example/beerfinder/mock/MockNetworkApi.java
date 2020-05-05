package com.example.beerfinder.mock;

import com.example.beerfinder.model.Beer;
import com.example.beerfinder.network.NetworkApi;
import com.example.beerfinder.network.NetworkInteractor;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.mock.Calls;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockNetworkApi implements NetworkApi {

    @Mock
    public static NetworkInteractor interactor;

    private static void generateMockWebService() throws IOException {

    }

    @Override
    public Call<List<Beer>> listBeers() {
        return null;
    }
}
