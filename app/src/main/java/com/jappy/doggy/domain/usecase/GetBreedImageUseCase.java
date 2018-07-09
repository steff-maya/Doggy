package com.jappy.doggy.domain.usecase;

import com.jappy.doggy.data.repository.BreedImageRepository;
import com.jappy.doggy.domain.model.BreedImage;
import com.jappy.jappy_core.domian.usecase.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class GetBreedImageUseCase extends UseCase<BreedImage> {

    BreedImageRepository puppiesImageRepository;
    private String  data;

    @Inject
    public GetBreedImageUseCase(BreedImageRepository puppiesImageRepository) {
        this.puppiesImageRepository=puppiesImageRepository;
    }

    public GetBreedImageUseCase setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    protected Observable<BreedImage> createObservableUseCase() {
        return puppiesImageRepository.getPuppiesImage(data);
    }

}