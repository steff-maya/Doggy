package com.jappy.doggy.di;

import com.jappy.doggy.presentation.BreedFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by irenecedeno on 09-02-18.
 */

@Singleton
@Component(modules = {BreedModule.class})
public interface BreedComponent extends  FragmentComponent<BreedFragment> {

}
