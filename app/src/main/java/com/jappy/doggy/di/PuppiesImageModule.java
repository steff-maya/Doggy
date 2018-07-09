package com.jappy.doggy.di;

import com.jappy.doggy.data.remote.ApiServiceFactory;
import com.jappy.doggy.data.remote.DoggyApi;
import com.jappy.doggy.data.repository.BreedImageRepositoryImp;
import com.jappy.doggy.data.repository.BreedImageRepository;
import com.jappy.doggy.data.repository.mappers.PuppiesToDomainMappe;
import com.jappy.doggy.domain.usecase.GetBreedImageUseCase;
import com.jappy.doggy.presentation.adapter.ImageCardAdapter;
import com.jappy.doggy.presentation.contract.BreedImageContract;
import com.jappy.doggy.presentation.presenter.BreedImagePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by irenecedeno on 10-02-18.
 */

@Module
public class PuppiesImageModule {
    PuppiesToDomainMappe puppiesToDomainMappe;

    @Provides
    OkHttpClient provideOkHttpClient(){return new OkHttpClient();}



    @Provides
    BreedImageRepository PuppiesImageRepository(DoggyApi apiService, PuppiesToDomainMappe puppiesToDomainMappe ) {
        return new BreedImageRepositoryImp(apiService,puppiesToDomainMappe) {
        };
    }

    @Provides
    BreedImageContract.Presenter providePresenter(GetBreedImageUseCase puppiesToDomainMappe) {
        return new BreedImagePresenter(puppiesToDomainMappe);


    }

    @Provides
    @Singleton
    public ImageCardAdapter provideAdapter() {
        return new ImageCardAdapter();
    }


    @Provides @Singleton
    DoggyApi provideApiService(OkHttpClient okHttpClient) {
        return ApiServiceFactory.build(okHttpClient, DoggyApi.class, "https://dog.ceo/api/");
    }

}
