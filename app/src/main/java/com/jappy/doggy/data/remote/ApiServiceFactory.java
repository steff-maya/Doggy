package com.jappy.doggy.data.remote;

import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by irenecedeno on 09-02-18.
 */

public class ApiServiceFactory {
    public static <T> T build(OkHttpClient client, Class<T> serviceClass, String urlBase) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Log.e("TAG retrofit",retrofit.baseUrl().toString());
        return retrofit.create(serviceClass);
    }
}
