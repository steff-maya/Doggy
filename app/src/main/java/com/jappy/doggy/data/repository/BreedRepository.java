package com.jappy.doggy.data.repository;

import com.jappy.doggy.domain.model.Breed;

import io.reactivex.Observable;

/**
 * Created by irenecedeno on 09-02-18.
 */

public interface BreedRepository {
    Observable<Breed> getBreed();
    void  getAll();
}
