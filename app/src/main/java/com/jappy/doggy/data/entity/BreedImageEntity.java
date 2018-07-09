package com.jappy.doggy.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by irenecedeno on 09-02-18.
 */

public class BreedImageEntity {
    @SerializedName("status")
    @Expose
    private String status ;
    @SerializedName("message")
    @Expose
    private List<String> message ;
}
