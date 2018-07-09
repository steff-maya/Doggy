package com.jappy.doggy.presentation.presenter;

import android.util.Log;

import com.jappy.doggy.data.remote.DoggyApi;
import com.jappy.doggy.domain.model.Breed;
import com.jappy.doggy.domain.usecase.GetBreedUseCase;
import com.jappy.doggy.presentation.contract.BreedContract;
import com.jappy.jappy_core.domian.usecase.UseCaseObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by irenecedeno on 09-02-18.
 */

public class BreedPresenter implements BreedContract.Presenter {
    GetBreedUseCase getPuppiesUseCase;
    BreedContract.View view;
    DoggyApi apiService;
    List<String> breed = new ArrayList<>();



    @Inject
    public BreedPresenter(GetBreedUseCase getPuppiesUseCase) {
        this.getPuppiesUseCase = getPuppiesUseCase;


    }

    @Override
    public void initialize(BreedContract.View view) {
        Log.e(" ininin", "iniwer");
        this.view = view;
        view.initToolbar("Doggy");
        view.showProgress(true);
        requestPuppies();

    }

    @Override
    public void cancelObservable() {
        getPuppiesUseCase.dispose();
    }


    private void requestPuppies() {
        getPuppiesUseCase.execute(new UseCaseObserver<Breed>() {
            @Override
            public void onNext(Breed value) {
                Iterator entries = value.message.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry thisEntry = (Map.Entry) entries.next();
                    thisEntry.getKey();
                    String key = (String) thisEntry.getKey();
                    breed.add(key);
                    Log.e("ininin", key);


                    // ...
                }


            }


            @Override
            public void onError(Throwable e) {

                Log.e(" ininin erroer", e.toString());
                view.showProgress(false);
                view.showError(true);
            }

            @Override
            public void onComplete() {
                super.onComplete();
                Log.e("ininin", "termino");
                view.showdog(breed);
                view.showProgress(false);


            }
        });


    }




}
