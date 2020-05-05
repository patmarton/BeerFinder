package com.example.beerfinder.test;

import android.os.Build;

import com.example.beerfinder.TestApplication;
import com.example.beerfinder.mock.MockBeerRepository;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.presenter.ListPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class ListTest {

    @Spy
    private ListPresenter listPresenter;

    @Before
    public void startup() {
        MockBeerRepository.init();
        listPresenter = spy(new ListPresenter());

        Beer beer= new Beer();
        beer.setAbv(5);
        beer.setBeerId(new Long(1));
        beer.setDescription("Test");
        beer.setTagline("Testtag");
        MockBeerRepository.mockTable.add(beer);

        List<Beer> beers = new ArrayList<Beer>();
        beers.add(beer);

        listPresenter.persistBeer(beers);

    }

    @Test
    @Config(sdk = Build.VERSION_CODES.O_MR1)
    public void presenterDeleteBeer(){

        listPresenter.deleteBeerById(new Long(1));
        //Assert
        verify(MockBeerRepository.mockDatabaseRepository, times(1)).DeleteBeerById(anyLong());
        Assert.assertEquals(0, MockBeerRepository.mockTable.size());
    }

}
