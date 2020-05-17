package com.example.beerfinder.mock;

import com.example.beerfinder.model.Beer;
import com.example.beerfinder.network.NetworkApi;
import com.example.beerfinder.network.NetworkInteractor;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Request;

import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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


    public MockNetworkApi() {
    }

    @Override
    public Call<List<Beer>> listBeers() {
        List<Beer> beers = new ArrayList<Beer>();

        Beer b1 = new Beer();
        b1.setAbv(5);
        b1.setBeerId(new Long(1));
        b1.setTagline("Tag");
        b1.setDescription("Test");

        Beer b2 = new Beer();
        b1.setAbv(5);
        b1.setBeerId(new Long(2));
        b1.setTagline("Tag");
        b1.setDescription("Test");

        beers.add(b1);
        beers.add(b2);

        Call<List<Beer>> call = new Call<List<Beer>>() {
            @Override
            public Response<List<Beer>> execute() throws IOException {
                return Response.success(beers);
            }

            @Override
            public void enqueue(Callback<List<Beer>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Beer>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }

            @Override
            public Timeout timeout() {
                return null;
            }
        };


        return null;
    }
}
