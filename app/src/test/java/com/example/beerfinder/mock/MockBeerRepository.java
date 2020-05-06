package com.example.beerfinder.mock;

import com.example.beerfinder.db.Repository;
import com.example.beerfinder.model.Beer;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;

public class MockBeerRepository extends Repository {






    @Mock
    public static Repository mockDatabaseRepository = Mockito.mock(Repository.class);;

    public static List<Beer> mockTable = new ArrayList<>();;


    public static void init(){
        generateMockRespository();
    }

    private static void generateMockRespository() {

        mockTable = new ArrayList<>();
        mockDatabaseRepository = Mockito.mock(Repository.class);

        doAnswer(invocation -> {
            List<Beer> beers = invocation.getArgument(0);

            mockTable.addAll(beers);

            return null;
        }).when(mockDatabaseRepository).insertBeers(anyListOf(Beer.class));

        doAnswer(invocation -> {
            Beer beer = invocation.getArgument(0);

            mockTable.remove(beer);

            return null;
        }).when(mockDatabaseRepository).DeleteBeer(any(Beer.class));

        doAnswer(invocation -> {
            Long beerId = invocation.getArgument(0);

            mockTable.removeIf(book -> book.getBeerId().equals(beerId));

            return null;
        }).when(mockDatabaseRepository).DeleteBeerById(anyLong());



    }


    @Override
    public void insertBeers(List<Beer> beers) {
        super.insertBeers(beers);
    }

    @Override
    public List<Beer> getAllBeers() {
        return super.getAllBeers();
    }

    @Override
    public Beer getBeerById(Long beerId) {
        return super.getBeerById(beerId);
    }

    @Override
    public void DeleteBeer(Beer beer) {
        super.DeleteBeer(beer);
    }

    @Override
    public void DeleteBeerById(Long beerId) {
        super.DeleteBeerById(beerId);
    }
}
