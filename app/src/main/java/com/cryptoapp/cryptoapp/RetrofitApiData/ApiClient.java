package com.cryptoapp.cryptoapp.RetrofitApiData;

import com.cryptoapp.cryptoapp.ApiData.PostList2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ApiClient {
    private static String URL = "https://jsonplaceholder.typicode.com/";

    private static PostService postService = null;

    public static PostService getService() {

        if (postService == null) {
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService {
        @GET("users")
        Call<PostList2> getPostList();
    }
}