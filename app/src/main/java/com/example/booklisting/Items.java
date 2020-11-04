package com.example.booklisting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {
    @SerializedName("items")
    @Expose
    private List<Information> items;
    public List<Information> getInformation() {
        return items;
    }



}
