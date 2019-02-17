package com.cryptoapp.cryptoapp.WithImage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cryptoapp.cryptoapp.R;
import com.cryptoapp.cryptoapp.SimpleDividerItemDecoration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    private final String TAG = "ImageActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        recyclerView = (RecyclerView) findViewById(R.id.list_item3);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ImageActivity.this,2);
//        layoutManager = new LinearLayoutManager(ImageActivity.this);
        recyclerView.setLayoutManager(gridLayoutManager);
        requestJsonObject();
    }

    private void requestJsonObject() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/photos";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response " + response);
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                List<PostList3> posts = new ArrayList<PostList3>();
                posts = Arrays.asList(mGson.fromJson(response, PostList3[].class));
                adapter = new RecyclerViewAdapter3(ImageActivity.this, posts);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
