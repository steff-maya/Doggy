package com.jappy.doggy.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class Dog {

    public String raza;
    public List<String> image;

    public Dog(String raza, List<String> image) {
        this.raza = raza;
        this.image = image;
    }

    public Dog(String raza, String s) {
    }
}
