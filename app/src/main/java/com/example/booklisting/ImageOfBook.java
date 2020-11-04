package com.example.booklisting;

import com.google.gson.annotations.SerializedName;

public class ImageOfBook {
    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    private String thumbNail;
    public String getSmallThumbnail() {
        return smallThumbnail;
    }
    public String getThumbNail(){
        return thumbNail;
    }
    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }
}