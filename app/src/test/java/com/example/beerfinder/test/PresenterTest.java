package com.example.beerfinder.test;


import android.os.Build;

import com.example.beerfinder.TestApplication;
import com.example.beerfinder.mock.MockBeerRepository;
import com.example.beerfinder.model.Beer;
import com.example.beerfinder.presenter.DetailsPresenter;
import com.example.beerfinder.presenter.ListPresenter;
import com.example.beerfinder.view.ListActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

import static org.mockito.Mockito.spy;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class PresenterTest {

    @Spy
    ListPresenter listPresenter;

    @Inject
    ListPresenter mockPresenter;

    @Spy
    DetailsPresenter detailsPresenter;

    @Mock
    ListActivity listActivity;

    List<Beer> beerlist;

    @Before
    public void startup(){

        listActivity = Mockito.mock(ListActivity.class);
        TestApplication.injector.inject(listActivity);
        mockPresenter = listActivity.listPresenter;
        mockPresenter.attachScreen(listActivity);

        MockBeerRepository.init();

        listPresenter = spy(new ListPresenter());
        detailsPresenter = spy(new DetailsPresenter());

        Beer beer= new Beer();
        beer.setAbv(5);
        beer.setBeerId(new Long(1));
        beer.setDescription("Test");
        beer.setTagline("Testtag");
        beer.setName("TestName");
        MockBeerRepository.mockTable.add(beer);

        beerlist = new ArrayList<>();

        beerlist.add(beer);
    }


    @Test
    @Config(sdk = Build.VERSION_CODES.O_MR1)
    public void extractNameTest() throws IOException {

        List<String> names = listPresenter.extractName(beerlist);

        Assert.assertEquals("TestName", names.get(0));
    }

    @Test
    @Config(sdk = Build.VERSION_CODES.O_MR1)
    public void getNameTest() throws IOException {

        Beer beer = detailsPresenter.getBeer(beerlist,"TestName");

        Assert.assertEquals("TestName", beer.getName());
    }

   @Test
    @Config(sdk = Build.VERSION_CODES.O_MR1)
    public void getBeer() throws IOException {

        List<Beer> beer = listPresenter.getAllBeers();

        Assert.assertEquals(2, beer.size());
    }

}
