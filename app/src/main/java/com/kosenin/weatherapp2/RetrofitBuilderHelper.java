package com.kosenin.weatherapp2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Konstantin2 on 28.06.2017.
 */

public class RetrofitBuilderHelper {

    private static final String URL = "http://api.openweathermap.org/data/2.5/";


    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);




}
