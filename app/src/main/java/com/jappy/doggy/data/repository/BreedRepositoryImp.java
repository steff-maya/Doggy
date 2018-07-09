package com.jappy.doggy.data.repository;

import android.util.Log;

import com.google.gson.Gson;
import com.jappy.doggy.data.remote.DoggyApi;
import com.jappy.doggy.data.remote.response.BreedResponse;
import com.jappy.doggy.data.repository.mappers.BreedToDomainMapper;
import com.jappy.doggy.domain.model.Breed;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by irenecedeno on 09-02-18.
 */

public class BreedRepositoryImp implements BreedRepository {

    DoggyApi apiService;
    BreedToDomainMapper breedToDomainMapper;


    @Inject
    public BreedRepositoryImp(DoggyApi apiService, BreedToDomainMapper breedToDomainMapper) {
        this.apiService = apiService;
        this.breedToDomainMapper=breedToDomainMapper;

    }


    @Override
    public Observable<Breed> getBreed() {
       return apiService.getBreed().map(new Function<BreedResponse, Breed>() {
            @Override
            public Breed apply(BreedResponse breedResponse) throws Exception {
                Gson a =new  Gson ();
                Log.e("LOG",a.toJson(breedResponse.message));
                return breedToDomainMapper.map(breedResponse);
            }
        });


    }

    @Override
    public void getAll() {

    }






}