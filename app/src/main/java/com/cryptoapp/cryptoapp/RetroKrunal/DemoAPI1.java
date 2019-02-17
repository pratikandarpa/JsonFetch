package com.cryptoapp.cryptoapp.RetroKrunal;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class DemoAPI1 {
    private static String URL = "https://demonuts.com/Demonuts/JsonTest/Tennis/";

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
        @GET("json_parsing")
        Call<PostList1> getPostList();
    }

}
