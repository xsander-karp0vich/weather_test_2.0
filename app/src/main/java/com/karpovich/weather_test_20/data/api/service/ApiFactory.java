package com.karpovich.weather_test_20.data.api.service;
import com.karpovich.weather_test_20.data.api.pojo.response.WeatherForecastResponse;
import com.karpovich.weather_test_20.data.api.pojo.response.WeatherResponse;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    public static final ApiService apiService = retrofit.create(ApiService.class);
}
