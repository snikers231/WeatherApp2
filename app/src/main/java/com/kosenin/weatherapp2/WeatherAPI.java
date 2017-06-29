package com.kosenin.weatherapp2;

import com.kosenin.weatherapp2.Helpers.WeatherData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Konstantin2 on 28.06.2017.
 */

public interface WeatherAPI {

        //root is not a list
        @GET("weather")
        Call<WeatherData> getWeatherToday(@Query("q") String name,
                                          @Query("lang") String lang,
                                          @Query("units") String units,
                                          @Query("apiKey") String apiKey);



    @GET("forecast")
    Call<WeatherData> getForecast5Days(@Query("q") String name,
                                            @Query("lang") String lang,
                                            @Query("units") String units,
                                            @Query("apiKey") String apiKey);

}