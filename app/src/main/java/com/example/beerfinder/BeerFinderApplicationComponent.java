package com.example.beerfinder;
import com.example.beerfinder.db.Repository;
import com.example.beerfinder.network.NetworkInteractor;
import com.example.beerfinder.network.NetworkModule;
import com.example.beerfinder.presenter.DetailsPresenter;
import com.example.beerfinder.presenter.ListPresenter;
import com.example.beerfinder.view.DetailsActivity;
import com.example.beerfinder.view.ListActivity;

import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component(modules = { UIModule.class, NetworkModule.class})
public interface BeerFinderApplicationComponent {
    void inject(ListActivity listActivity);
    void inject(ListPresenter listPresenter);
    void inject(DetailsActivity detailActivity);
    void inject(DetailsPresenter detailPresenter);
    void inject(Repository repository);
    void inject(NetworkInteractor networkInteractor);

}
