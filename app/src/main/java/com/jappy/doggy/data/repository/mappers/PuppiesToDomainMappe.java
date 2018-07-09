package com.jappy.doggy.data.repository.mappers;

import com.jappy.doggy.data.remote.response.BreedImageResponse;
import com.jappy.doggy.domain.model.BreedImage;
import com.jappy.jappy_core.data.repository.Mapper;

import javax.inject.Inject;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class PuppiesToDomainMappe extends Mapper<BreedImageResponse, BreedImage> {


    @Inject
    public PuppiesToDomainMappe() {


    }


    @Override
    public BreedImage map(BreedImageResponse value) {
        BreedImage puppiesImage = new BreedImage();
        puppiesImage.status = value.status;
        puppiesImage.message = value.message;

        return puppiesImage;

    }

    @Override
    public BreedImageResponse reverseMap(BreedImage value) {
        throw new UnsupportedOperationException();
    }
}
