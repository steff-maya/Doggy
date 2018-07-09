package com.jappy.doggy.presentation;


import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.View;

import com.jappy.doggy.R;
import com.jappy.doggy.databinding.FragmentPuppiesImageBinding;
import com.jappy.doggy.di.DaggerBreedImageComponent;
import com.jappy.doggy.presentation.adapter.ImageCardAdapter;
import com.jappy.doggy.presentation.contract.BreedImageContract;
import com.jappy.jappy_core.presentation.BaseFragment;
import com.jappy.jappy_core.utils.CurveTransformer;
import com.jappy.jappy_core.utils.GalleryLayoutManager;

import java.util.List;

import javax.inject.Inject;


/**
 * A simple {@link Fragment} subclass.
 */
public class BreedImageFragment extends BaseFragment<FragmentPuppiesImageBinding> implements BreedImageContract.View{

    @Inject
    BreedImageContract.Presenter presenter;
    @Inject
    ImageCardAdapter adapter;
    private String bread;



    public static BreedImageFragment newInstance(String bread) {
        BreedImageFragment fragment = new BreedImageFragment();
        fragment.bread=bread;
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_puppies_image;
    }

    @Override
    protected void initView() {
        presenter.initialize(this);
        presenter.getImages(bread);


    }


    @Override
    protected void injectDependencies() {
        DaggerBreedImageComponent.builder().build().inject(this);

      

    }

    @Override
    public void showProgress(boolean show) {
        binder.progressView.setVisibility(show? View.VISIBLE:View.GONE);

    }

    @Override
    public void showError(boolean show) {
        binder.errorView.setVisibility(show? View.VISIBLE:View.GONE);
    }

    @Override
    public void initToolbar(String breed) {
       binder.includedToolbar.ivBack.setVisibility(View.VISIBLE);
       binder.includedToolbar.tvName.setText(breed);
       binder.includedToolbar.ivBack.setOnClickListener(view -> {
           popBackStack();

       });


    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showImage(List<String> breed) {
        binder.pagerRecycleView.setFlingAble(false);
        GalleryLayoutManager layoutManager = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        layoutManager.attach(binder.pagerRecycleView, 30);
        layoutManager.attach(binder.pagerRecycleView);
        layoutManager.setItemTransformer(new CurveTransformer());
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        adapter.initializeList(breed);

        binder.pagerRecycleView.setAdapter(adapter);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.cancelObservable();
    }
}
