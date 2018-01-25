package com.example.dc.retrofit_lib;

import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tmd on 25/04/2017.
 */
// TODO: 25/04/2017 2
public interface GithubService {

    @GET("users/list")// TODO: 25/04/2017 4

        // TODO: 25/04/2017 3 // tra lai String
//    Call<ResponseBody> getGithub();

        // TODO: 25/04/2017 7 // tra lai roi ep thanh Object
    Call<GithubModel> getGithub(@Query("sort") String sortValue);// /users/list?sort=sortValue

}
