package com.karpovich.weather_test_20.data.api.service;
import com.karpovich.weather_test_20.data.api.pojo.response.WeatherForecastResponse;
import com.karpovich.weather_test_20.data.api.pojo.response.WeatherResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("weather")
    Single<WeatherResponse> loadWeather(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String apiKey);

    @GET("forecast")
    Single<WeatherForecastResponse> loadWeatherForecast(@Query("lat") double lat, @Query("lon") double lon, @Query("cnt") int cnt, @Query("appid") String apiKey);

    @GET("weather")
    Single<WeatherResponse> loadWeatherByCityName(@Query("q") String city,@Query("appid") String apiKey);

    @GET("forecast")
    Single<WeatherForecastResponse> loadWeatherForecastByCityName(@Query("q") String city,@Query("cnt") int cnt,@Query("appid") String apiKey);
}
