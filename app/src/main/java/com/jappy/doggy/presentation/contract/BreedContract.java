package com.jappy.doggy.presentation.contract;

import android.view.View;

import com.jappy.jappy_core.presentation.IProgressView;
import com.jappy.jappy_core.presentation.presenter.BaseViewPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irenecedeno on 09-02-18.
 */

public class BreedContract {
    public interface View extends IProgressView {
        void showdog(List<String> breed);
        void showProgress(boolean show);
        void showError(boolean show);
        void initToolbar(String breed);


    }
    public interface Presenter extends BaseViewPresenter<View> {
        void initialize(View view);
        void cancelObservable();



    }
}
