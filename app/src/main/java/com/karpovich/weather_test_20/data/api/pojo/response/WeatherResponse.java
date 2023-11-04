package com.karpovich.weather_test_20.data.api.pojo.response;
import com.karpovich.weather_test_20.data.api.pojo.weather.Main;
import com.karpovich.weather_test_20.data.api.pojo.weather.Weather;
import com.karpovich.weather_test_20.data.api.pojo.weather.Wind;

import java.util.Arrays;

public class WeatherResponse {
    String name;
    Weather[] weather;
    Wind wind;
    Main main;

    public WeatherResponse(String name, Weather[] weather, Wind wind, Main main) {
        this.name = name;
        this.weather = weather;
        this.wind = wind;
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public Main getMain() {
        return main;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "name='" + name + '\'' +
                ", weather=" + Arrays.toString(weather) +
                ", wind=" + wind +
                ", main=" + main +
                '}';
    }
}
