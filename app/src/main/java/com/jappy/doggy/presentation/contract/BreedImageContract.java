package com.jappy.doggy.presentation.contract;

import com.jappy.jappy_core.presentation.IProgressView;
import com.jappy.jappy_core.presentation.presenter.BaseViewPresenter;

import java.util.List;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class BreedImageContract {
    public interface View extends IProgressView {
        void showImage(List<String> breed);
        void showProgress(boolean show);
        void showError(boolean show);
        void initToolbar(String breed);
    }



    public interface Presenter extends BaseViewPresenter<BreedImageContract.View> {
        void initialize(BreedImageContract.View view);
        void getImages(String name);
        void cancelObservable();



    }
}
