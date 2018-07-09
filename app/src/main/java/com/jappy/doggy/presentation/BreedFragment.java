package com.jappy.doggy.presentation;


import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.jappy.doggy.R;
import com.jappy.doggy.databinding.FragmentBreedBinding;
import com.jappy.doggy.di.DaggerBreedComponent;
import com.jappy.doggy.presentation.adapter.BreedAdapter;
import com.jappy.doggy.presentation.contract.BreedContract;
import com.jappy.jappy_core.presentation.BaseStackFragment;
import com.jappy.jappy_core.presentation.OnItemClickListener;
import com.jappy.jappy_core.utils.GridSpacingItemDecoration;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreedFragment extends BaseStackFragment<FragmentBreedBinding> implements BreedContract.View{

    @Inject
    BreedContract.Presenter presenter;
    @Inject
    BreedAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_breed;
    }

    @Override
    protected void initView() {
        presenter.initialize(this);

    }

    @Override
    protected void injectDependencies() {
        DaggerBreedComponent.builder().build().inject(this);



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
    public void showMessage(String message) {

    }

    @Override
    public void initToolbar(String breed) {
       binder.includedToolbar.ivBack.setVisibility(View.GONE);
       binder.includedToolbar.tvName.setText(breed);


    }

    @Override
    public void showdog(List<String> dog) {
        adapter.initializeList(dog);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        binder.rvPuppies.setLayoutManager(mLayoutManager);
        binder.rvPuppies.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        binder.rvPuppies.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnAddToListListener(new OnItemClickListener<String>() {

            @Override
            public void onItemClick(int adapterPosition, String breed) {

                if(breed!=null){
                    Log.e("inini",breed);
                    getBaseStackFragment().addFragmentToStack(BreedImageFragment.newInstance( breed));
                }



            }
        });
        binder.rvPuppies.setAdapter(adapter);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    @Override
    protected int getNavigationContainer() {
        return R.id.stackContainer;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.cancelObservable();
    }
}
