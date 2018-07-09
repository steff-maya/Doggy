package com.jappy.doggy.data.repository.mappers;

import com.jappy.doggy.data.remote.response.BreedResponse;
import com.jappy.doggy.domain.model.Breed;
import com.jappy.jappy_core.data.repository.Mapper;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class BreedToDomainMapper extends Mapper<BreedResponse,Breed> {
    BreedToDomainMapper dogMapper;

    @Inject
    public BreedToDomainMapper() {


    }


    @Override
    public Breed map(BreedResponse value) {
        Breed breed = new Breed();
        breed.status=value.status;
        breed.message=value.message;

        return  breed;

    }

    @Override
    public BreedResponse reverseMap(Breed value) {
        throw new UnsupportedOperationException();
    }
}