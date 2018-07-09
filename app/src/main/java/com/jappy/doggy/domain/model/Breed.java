package com.jappy.doggy.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by irenecedeno on 09-02-18.
 */

public class  Breed {
    public String status;
    public Map<String, List<String>> message;
}

