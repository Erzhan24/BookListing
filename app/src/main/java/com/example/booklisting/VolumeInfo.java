package com.example.booklisting;

import androidx.core.app.NotificationCompat;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VolumeInfo implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private List<String> authors;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("pageCount")
    private String pageCount;
    @SerializedName("averageRating")
    private float averageRating;
    @SerializedName("imageLinks")
    private ImageOfBook imageLinks;
    @SerializedName("previewLink")
    private String previewLink;


    public VolumeInfo(String title, String pageCount, String publishedDate, float averageRating, List<String> authors, ImageOfBook imageLinks, String previewLink) {

        this.title = title;
        this.pageCount = pageCount;
        this.publishedDate = publishedDate;
        this.averageRating = averageRating;
        this.authors = authors;
        this.imageLinks = imageLinks;
        this.previewLink = previewLink;
    }


    public String getTitle() {
        return title;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
    public String getPageCount() {
        return pageCount;
    }
    public float getAverageRating() {
        return averageRating;
    }
    public ImageOfBook getImageLinks() { return imageLinks; }
    public String getPreviewLink() {
        return previewLink;
    }


}



