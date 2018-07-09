package com.jappy.doggy.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jappy.doggy.R;
import com.jappy.doggy.databinding.ActivityDogBinding;
import com.jappy.jappy_core.presentation.BaseFragmentActivity;

public class DogActivity extends BaseFragmentActivity<ActivityDogBinding> {


    @Override
    protected int getFragmentContainerId() {
        return R.id.tabContainer;
    }

    @Override
    protected void initView() {
        addFragment(new BreedFragment(),true);

    }

    @Override
    protected void injectDependencies() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dog;
    }
}
