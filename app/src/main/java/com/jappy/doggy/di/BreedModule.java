package com.jappy.doggy.di;

import com.jappy.doggy.data.remote.ApiServiceFactory;
import com.jappy.doggy.data.remote.DoggyApi;
import com.jappy.doggy.data.repository.BreedRepository;
import com.jappy.doggy.data.repository.BreedRepositoryImp;
import com.jappy.doggy.data.repository.mappers.BreedToDomainMapper;
import com.jappy.doggy.domain.usecase.GetBreedUseCase;
import com.jappy.doggy.presentation.contract.BreedContract;
import com.jappy.doggy.presentation.adapter.BreedAdapter;
import com.jappy.doggy.presentation.presenter.BreedPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by irenecedeno on 09-02-18.
 */
@Module
public class BreedModule {

    BreedToDomainMapper breedToDomainMapper;


    @Provides
    OkHttpClient provideOkHttpClient(){return new OkHttpClient();}

    @Provides
    BreedRepository provideRepository(DoggyApi apiService,BreedToDomainMapper breedToDomainMapper ) {
        return new BreedRepositoryImp(apiService,breedToDomainMapper) {
        };
    }



    @Provides
    BreedContract.Presenter providePresenter(GetBreedUseCase getPuppiesUseCase) {
        return new BreedPresenter(getPuppiesUseCase);


    }

    @Provides
    @Singleton
    public BreedAdapter provideAdapter() {
        return new BreedAdapter();
    }


    @Provides @Singleton
    DoggyApi provideApiService(OkHttpClient okHttpClient) {
        return ApiServiceFactory.build(okHttpClient, DoggyApi.class, "https://dog.ceo/api/");
    }

}
