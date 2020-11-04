package com.example.booklisting;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface BooksAPI {
    @GET("volumes?")
    Call<Information> retrieveData(
            @Query("q") String input,
            @Query("maxResults") int maxResults);
}
