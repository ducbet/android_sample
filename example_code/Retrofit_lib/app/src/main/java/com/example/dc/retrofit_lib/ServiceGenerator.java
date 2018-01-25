package com.example.dc.retrofit_lib;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tmd on 25/04/2017.
 */

public class ServiceGenerator {
    // TODO: 25/04/2017 1
    private static final String BASE_URL = "https://api.github.com/";

    private static Retrofit retrofit = null;
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    // Khai bao log de lay ra gia tri cua request
    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor);

    private static OkHttpClient okHttpClient = okHttpClientBuilder.build();

    public static <T> T createService(Class<T> serviceClass) {
        // khoi tao retrofit
        if (retrofit == null) {
            //        retrofit = builder.build(); //dung neu khong can logging
            retrofit = builder.client(okHttpClient).build();
        }
        return retrofit.create(serviceClass);
    }
}
