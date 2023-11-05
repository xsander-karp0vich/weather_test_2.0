package com.karpovich.weather_test_20.data.repository;

import com.karpovich.weather_test_20.data.api.pojo.response.WeatherForecastResponse;
import com.karpovich.weather_test_20.data.api.pojo.response.WeatherResponse;
import com.karpovich.weather_test_20.data.api.service.ApiFactory;
import com.karpovich.weather_test_20.data.api.service.ApiService;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AppRepository{

    private final ApiService apiService;

    public AppRepository() {
        apiService = ApiFactory.apiService;
    }

    private static final String API_KEY = "0ae590706091ef379c1aaeb379d4dad8";

    public Single<WeatherResponse> loadWeather(double lat, double lon) {
        return apiService.loadWeather(lat, lon, API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<WeatherForecastResponse> loadWeatherForecast(double lat, double lon, int cnt) {
        return apiService.loadWeatherForecast(lat, lon, cnt, API_KEY);
    }

    public Single<WeatherResponse> loadWeatherByCityName(String city) {
        return apiService.loadWeatherByCityName(city, API_KEY);
    }

    public Single<WeatherForecastResponse> loadWeatherForecastByCityName(String city, int cnt) {
        return apiService.loadWeatherForecastByCityName(city, cnt, API_KEY);
    }
}
