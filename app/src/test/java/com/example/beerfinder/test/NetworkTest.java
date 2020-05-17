package com.example.beerfinder.test;

import android.os.Build;

import com.example.beerfinder.mock.MockBeerRepository;
import com.example.beerfinder.mock.MockNetworkApi;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.presenter.ListPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class NetworkTest {

    @Inject
    ListPresenter listPresenter;


    @Spy
    MockNetworkApi mockNetworkApi;

    @Before
    public void startup(){
        MockBeerRepository.init();

        mockNetworkApi = spy(new MockNetworkApi());

        Beer beer= new Beer();
        beer.setAbv(5);
        beer.setBeerId(new Long(1));
        beer.setDescription("Test");
        beer.setTagline("Testtag");
        MockBeerRepository.mockTable.add(beer);


    }

}
