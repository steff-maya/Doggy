package com.jappy.doggy.di;

import com.jappy.doggy.presentation.BreedImageFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by irenecedeno on 10-02-18.
 */
@Singleton
@Component(modules = {PuppiesImageModule.class})
public interface BreedImageComponent extends  FragmentComponent<BreedImageFragment> {}
