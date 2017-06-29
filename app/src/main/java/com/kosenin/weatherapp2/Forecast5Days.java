package com.kosenin.weatherapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kosenin.weatherapp2.Helpers.Weather;
import com.kosenin.weatherapp2.Helpers.WeatherData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.data;

public class Forecast5Days extends AppCompatActivity {

    private static final String API_KEY = "be7dee010e120a3af05f191d88798bde";

    private RecyclerView forecastRecycler;
    private ArrayList<WeatherData> mWeatherData;
    private Forecast5DaysAdapter forecast5DaysAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_5_days);

        forecastRecycler = (RecyclerView) findViewById(R.id.forecast_5_daysRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        forecastRecycler.setLayoutManager(layoutManager);


        Intent intent = getIntent();
        final String cityName = intent.getStringExtra("cityName");

        if (!cityName.isEmpty()) {
            Call<WeatherData> call = RetrofitBuilderHelper.weatherAPI.getForecast5Days(cityName, "ru", "metric", API_KEY);

            call.enqueue(new Callback<WeatherData>() {
                @Override
                public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                    mWeatherData = new ArrayList<>(Arrays.asList(response.body()));
                    Forecast5DaysAdapter forecast5DaysAdapter = new Forecast5DaysAdapter(mWeatherData);
                    forecastRecycler.setAdapter(forecast5DaysAdapter);
                    forecastRecycler.setHasFixedSize(true);
                }

                @Override
                public void onFailure(Call<WeatherData> call, Throwable t) {
                    Toast toast = Toast.makeText(Forecast5Days.this, "Че-то не так", Toast.LENGTH_LONG);
                    toast.show();
                }
            });

        } else {
            Toast toast = Toast.makeText(Forecast5Days.this, "Че-то не так с интентом", Toast.LENGTH_LONG);
            toast.show();

        }


    }
}
