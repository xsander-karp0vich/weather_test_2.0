package com.karpovich.weather_test_20.data.api.pojo.weatherforecast;

import com.karpovich.weather_test_20.data.api.pojo.weather.Main;
import com.karpovich.weather_test_20.data.api.pojo.weather.Weather;
import com.karpovich.weather_test_20.data.api.pojo.weather.Wind;

import java.util.ArrayList;

public class WeatherList {
    public int dt;
    public Main main;
    public ArrayList<Weather> weather;
    public Wind wind;
    public double visibility;
    public double pop;

    public String dt_txt;


    public WeatherList(int dt, Main main, ArrayList<Weather> weather, Wind wind, int visibility, int pop, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.wind = wind;
        this.visibility = visibility;
        this.pop = pop;
        this.dt_txt = dt_txt;
    }

    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getPop() {
        return pop;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    @Override
    public String toString() {
        return "WeatherList{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", wind=" + wind +
                ", visibility=" + visibility +
                ", pop=" + pop +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}
