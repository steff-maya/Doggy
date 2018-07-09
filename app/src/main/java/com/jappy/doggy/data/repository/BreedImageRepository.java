package com.jappy.doggy.data.repository;

import com.jappy.doggy.domain.model.Breed;
import com.jappy.doggy.domain.model.BreedImage;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by irenecedeno on 09-02-18.
 */

public interface BreedImageRepository {
    Observable<BreedImage> getPuppiesImage(String name );

}
