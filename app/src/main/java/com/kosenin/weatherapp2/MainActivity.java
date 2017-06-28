package com.kosenin.weatherapp2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kosenin.weatherapp2.Helpers.WeatherData;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "be7dee010e120a3af05f191d88798bde";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DO NOT ROTATE SCREEN

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
/*
        final EditText city = (EditText) findViewById(R.id.input_city);


        ImageButton button = (ImageButton) findViewById(R.id.refresh_button);

       button.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {

                String cityName = String.valueOf(city.getText());

                //Checking if EditText isn't empty

                if (TextUtils.isEmpty(cityName)) {
                    city.setError("Введите город");
                    return;
                }
*/

        Intent intent = getIntent();
        String cityName = intent.getStringExtra("city");

        if (!cityName.isEmpty()) {
            //Sending request to OpenweatherMap using Retrofit and WeatherAPI request's constructor.

            Call<WeatherData> call = RetrofitBuilderHelper.weatherAPI.getWeatherToday(cityName, "ru", "metric", API_KEY);

            call.enqueue(new Callback<WeatherData>() {
                @Override
                public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                    if (response.isSuccessful()) {
                        //Retreiving data from OpenWeatherMap using Helpers and populating TextViews

                        //Rounding the temperature

                        int temperatureRounded = (int) Math.round(response.body().getMain().getTemp());


                        String temp = String.valueOf(temperatureRounded);
                        String humidity = String.valueOf(response.body().getMain().getHumidity());
                        String pressure = String.valueOf(response.body().getMain().getPressure());
                        String weatherMain = String.valueOf(response.body().getWeather().get(0).getDescription());
                        String windSpeed = String.valueOf(response.body().getWind().getSpeed());

                        //Creating Image URL for Picasso
                        String imageID = String.valueOf(response.body().getWeather().get(0).getIcon());
                        String imageUrl = "http://openweathermap.org/img/w/" + imageID + ".png";
                        //Receiving date from Server
                        long milliseconds = response.body().getDt();
                        Date d = new Date(milliseconds * 1000);
                        SimpleDateFormat simpleData = new SimpleDateFormat("dd.MM.yyyy");
                        String date = simpleData.format(d);


                        String message = String.valueOf(response.message());

                        //    TextView textview1 = (TextView) findViewById(R.id.buton);
                        //     textview1.setText(message);


                        TextView tempView = (TextView) findViewById(R.id.temp_today);
                        tempView.setText(temp + "°C");

                        TextView humView = (TextView) findViewById(R.id.humidity_today);
                        humView.setText(humidity + "%");

                        TextView presView = (TextView) findViewById(R.id.pressure_today);
                        presView.setText(pressure + " мм.рт.ст.");

                        TextView dateView = (TextView) findViewById(R.id.day_today);
                        dateView.setText(date);


                        TextView descriptionView = (TextView) findViewById(R.id.description_today);
                        descriptionView.setText(weatherMain);

                        TextView windSpeedView = (TextView) findViewById(R.id.windSpeed_today);
                        windSpeedView.setText(windSpeed + " м/c");

                        ImageView weatherImage = (ImageView) findViewById(R.id.today_weather_picture);
                        Picasso.with(MainActivity.this).load(imageUrl).into(weatherImage);


                    }

                    //If response to the API is not successful
                    else {

                        Toast toast = Toast.makeText(MainActivity.this, "Проверь название города блеать!", Toast.LENGTH_LONG);
                        toast.show();

                    }

                }

                @Override
                public void onFailure(Call<WeatherData> call, Throwable t) {

                }

                ;

                //  }
            });

//If string with cityName is empty
        } else {
            Toast toast = Toast.makeText(this, "Введи город на предыдущем экране, блеать!", Toast.LENGTH_LONG);
            toast.show();
        }


    }
}
