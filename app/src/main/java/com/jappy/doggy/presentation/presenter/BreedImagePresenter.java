package com.jappy.doggy.presentation.presenter;

import android.util.Log;

import com.jappy.doggy.domain.model.BreedImage;
import com.jappy.doggy.domain.usecase.GetBreedImageUseCase;
import com.jappy.doggy.presentation.contract.BreedImageContract;
import com.jappy.jappy_core.domian.usecase.UseCaseObserver;

import javax.inject.Inject;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class BreedImagePresenter implements BreedImageContract.Presenter{
    GetBreedImageUseCase getPuppiesImageUseCase;
    BreedImageContract.View view;

    @Inject
    public BreedImagePresenter(GetBreedImageUseCase getPuppiesImageUseCase) {

        this.getPuppiesImageUseCase = getPuppiesImageUseCase;

    }

    @Override
    public void initialize(BreedImageContract.View view) {
        this.view=view;



    }

    @Override
    public void getImages(String name) {
        view.showProgress(true);
        view.initToolbar(name);
        getPuppiesImageUseCase.setData(name).execute(new UseCaseObserver<BreedImage>() {
            @Override
            public void onNext(BreedImage img) {

                Log.e("ininin image", img.message.get(0));
                view.showImage(img.message);




            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                view.showProgress(false);
                view.showError(true);
            }

            @Override
            public void onComplete() {
                super.onComplete();
                view.showProgress(false);






                // view.showdog(breed,puppiesImg);
            }
        });
    }

    @Override
    public void cancelObservable() {
        getPuppiesImageUseCase.dispose();

    }


}
