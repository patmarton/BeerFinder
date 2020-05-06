package com.example.beerfinder.test;


import android.os.Build;

import com.example.beerfinder.mock.MockBeerRepository;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.presenter.ListPresenter;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class RepositoryTest {

    @Inject
    ListPresenter listPresenter;

    @Before
    public void startup(){
        MockBeerRepository.init();

        Beer beer= new Beer();
        beer.setAbv(5);
        beer.setBeerId(new Long(1));
        beer.setDescription("Test");
        beer.setTagline("Testtag");
        MockBeerRepository.mockTable.add(beer);
    }

    @Test
    @Config(sdk = Build.VERSION_CODES.O_MR1)
    public void deleteBeer_Test(){

        int id = 1;
        MockBeerRepository.mockDatabaseRepository.DeleteBeerById(new Long(1));
        //Assert
        verify(MockBeerRepository.mockDatabaseRepository, times(1)).DeleteBeerById(anyLong());
        Assert.assertEquals(0, MockBeerRepository.mockTable.size());
    }

    @Test
    @Config(sdk = Build.VERSION_CODES.O_MR1)
    public void deleteWrongBeer_Test(){

        int id = 1;
        MockBeerRepository.mockDatabaseRepository.DeleteBeerById(new Long(3));
        //Assert
        verify(MockBeerRepository.mockDatabaseRepository, times(1)).DeleteBeerById(anyLong());
        Assert.assertEquals(1, MockBeerRepository.mockTable.size());
    }

    @Test
    @Config(sdk = Build.VERSION_CODES.O_MR1)
    public void insertBeer_test(){

        Beer beer = new Beer();
        beer.setBeerId(new Long(2));
        beer.setTagline("Test");
        beer.setDescription("Test");
        beer.setAbv(5);

        List<Beer> beers = new ArrayList<Beer>();
        beers.add(beer);

        MockBeerRepository.mockDatabaseRepository.insertBeers(beers);
        //Assert
        verify(MockBeerRepository.mockDatabaseRepository, times(1)).insertBeers(anyList());
        Assert.assertEquals(2, MockBeerRepository.mockTable.size());
    }


}
