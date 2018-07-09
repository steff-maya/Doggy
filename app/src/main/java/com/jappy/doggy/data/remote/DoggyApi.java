package com.jappy.doggy.data.remote;

import com.jappy.doggy.data.remote.response.BreedResponse;
import com.jappy.doggy.data.remote.response.BreedImageResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by irenecedeno on 09-02-18.
 */

public interface DoggyApi {
    @GET("breed/{name}/images")
    Observable<BreedImageResponse> getPuppiesImages(@Path("name") String name) ;

    @GET("breeds/list/all")
    Observable<BreedResponse> getBreed() ;

    @GET("breeds/list/all")
    Call<BreedResponse> getBreeds();

    @GET("breed/{name}/images")
    Call<BreedImageResponse> getPuppiesImagefs(@Path("name") String name) ;

}
