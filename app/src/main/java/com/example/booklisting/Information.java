package com.example.booklisting;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Information {
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;
    private List<Information> items;
    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public List<Information> getInformation() {
        return items;
    }
}
