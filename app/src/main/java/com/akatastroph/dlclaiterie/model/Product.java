package com.akatastroph.dlclaiterie.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Genfinternet on 20/11/2016.
 */

public class Product {
    @SerializedName("name")
    String mName;

    @SerializedName("validity")
    int mValidity;
}
