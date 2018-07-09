package com.jappy.doggy.data.repository;

import com.jappy.doggy.data.remote.DoggyApi;

import org.junit.Test;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by irenecedeno on 10-02-18.
 */
public class BreedRepositoryImpTest {
    @Inject
    DoggyApi doggyApi;


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getBreed() throws Exception {
      //  doggyApi.getBreed();
    }

}