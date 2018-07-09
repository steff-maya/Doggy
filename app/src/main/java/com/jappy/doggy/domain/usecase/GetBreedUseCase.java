package com.jappy.doggy.domain.usecase;

import android.util.Log;

import com.jappy.doggy.data.repository.BreedRepository;
import com.jappy.doggy.domain.model.Breed;
import com.jappy.jappy_core.domian.usecase.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by irenecedeno on 09-02-18.
 */

public class GetBreedUseCase extends UseCase<Breed> {

    private final BreedRepository breedRepository;
    private String data;

    @Inject
    public GetBreedUseCase(BreedRepository breedRepository) {
        this.breedRepository=breedRepository;
    }

    public GetBreedUseCase setData(String data) {
        this.data = data;

        return this;
    }

    @Override
    protected Observable<Breed> createObservableUseCase() {
        Log.e(" ininin","requestPuppies");
        breedRepository.getAll();
        return breedRepository.getBreed();
    }

}
