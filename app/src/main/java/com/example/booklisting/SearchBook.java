package com.example.booklisting;

import android.content.Context;
import android.icu.text.IDNA;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchBook extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Information> myList = new ArrayList<>();
    private String result;
    private ProgressBar progressBar;
    private TextView emptyState;
    private Adapter adapter;
    private TextView textView;
    private static final String BASE_URL="https://www.googleapis.com/books/v1/";

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        recyclerView=findViewById(R.id.recycleview);
        retrofitInstance();
        }

        private void retrofitInstance() {
        result = getIntent().getExtras().getString("Search").trim();
        int maxResults = 20;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BooksAPI request = retrofit.create(BooksAPI.class);


        Call<Information> call = request.retrieveData(result, maxResults);

        call.enqueue(new Callback<Information>() {

            @Override
            public void onResponse(Call<Information> call, Response<Information> response) {


                myList = response.body().getInformation();


                if (myList != null) {
                    setAdapter();


                    for (int i = 0; i < myList.size(); i++) {
                        adapter.addAll(myList);

                    }
                } else {
                    adapter.clear();
                }
            }

            @Override
            public void onFailure(Call< Information> call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(), "onFailure");
                t.getMessage();

            }
        });
    }

    private void setAdapter() {
        adapter = new Adapter(myList, getApplicationContext());
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
