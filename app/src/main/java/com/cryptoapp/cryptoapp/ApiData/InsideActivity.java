package com.cryptoapp.cryptoapp.ApiData;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cryptoapp.cryptoapp.MainActivity;
import com.cryptoapp.cryptoapp.R;
import com.cryptoapp.cryptoapp.RetroKrunal.DemoAPI1;
import com.cryptoapp.cryptoapp.RetroKrunal.PostList1;
import com.cryptoapp.cryptoapp.RetroKrunal.Recycle_adapter;
import com.cryptoapp.cryptoapp.RetrofitApiData.ApiClient;
import com.cryptoapp.cryptoapp.RetrofitApiData.RecyclerViewAdapter4;
import com.cryptoapp.cryptoapp.SimpleDividerItemDecoration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsideActivity extends AppCompatActivity {

    private final String TAG = "InsideActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter4 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);

        recyclerView = (RecyclerView) findViewById(R.id.list_item2);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(InsideActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        getRetroData();
    }



    public void getRetroData() {

        Toast.makeText(this, "Retrofit", Toast.LENGTH_SHORT).show();

        Call<PostList1> postListCall = DemoAPI1.getService().getPostList();
        postListCall.enqueue(new Callback<PostList1>() {
            @Override
            public void onResponse(Call<PostList1> call, Response<PostList1> response) {
                PostList1 postList = response.body();

                GridLayoutManager gridLayoutManager = new GridLayoutManager(InsideActivity.this, 2);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(new Recycle_adapter(InsideActivity.this, postList.getData()));

            }

            @Override
            public void onFailure(Call<PostList1> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check your internet connection", Toast.LENGTH_LONG).show();

            }

        });
    }


//    private void requestJsonObject() {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "https://jsonplaceholder.typicode.com/users";
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d(TAG, "Response " + response);
//                GsonBuilder builder = new GsonBuilder();
//                Gson mGson = builder.create();
//                List<PostList2> posts = new ArrayList<PostList2>();
//                posts = Arrays.asList(mGson.fromJson(response, PostList2[].class));
//                adapter = new RecyclerViewAdapter2(InsideActivity.this, posts);
//                recyclerView.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d(TAG, "Error " + error.getMessage());
//            }
//        });
//        queue.add(stringRequest);
//    }

//    private void requestJsonObject() {
//
//        Call<PostList2> call = ApiClient.getService().getPostList();
//        call.enqueue(new Callback<PostList2>() {
//            @Override
//            public void onResponse(Call<PostList2> call, retrofit2.Response<PostList2> response) {
//                PostList2 abc = response.body();
//                recyclerView.setAdapter(new RecyclerViewAdapter4(InsideActivity.this, (List<PostList2>) abc));
//            }
//
//            @Override
//            public void onFailure(Call<PostList2> call, Throwable t) {
//                Log.e(TAG ,t.getMessage());
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//    private void generateDataList(List<PostList2> photoList) {
//        recyclerView = findViewById(R.id.list_item2);
//        adapter = new RecyclerViewAdapter4(getApplicationContext(),photoList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(InsideActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }
}
