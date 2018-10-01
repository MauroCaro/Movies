package com.example.mauriciocaro.movies.Network;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Connection {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(chain -> {
                Request original = chain.request();
                HttpUrl requestBuilder = original.url().newBuilder()
                        .addQueryParameter("api_key", "").build();
                Request request = original.newBuilder().url(requestBuilder).build();
                return chain.proceed(request);
            })
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(URL.BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
