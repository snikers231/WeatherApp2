package com.kosenin.weatherapp2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    private EditText cityStart;
    private Button cityStartButton;
    private Animation anim;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final EditText cityStart = (EditText) findViewById(R.id.start_city);
        Button cityStartButton = (Button) findViewById(R.id.start_cityButton);
        city = String.valueOf(cityStart.getText());
        anim = AnimationUtils.loadAnimation(StartActivity.this, android.R.anim.fade_out);

//
        cityStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                city = String.valueOf(cityStart.getText());
                Intent myIntent = new Intent(StartActivity.this, MainActivity.class);
                myIntent.putExtra("city", String.valueOf(city));
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), android.R.anim.slide_in_left, android.R.anim.slide_in_left).toBundle();
                startActivity(myIntent, bndlanimation);

            }
        });




        if (TextUtils.isEmpty(city)) {
            cityStart.setError("Введите город");
            return;
        }



    }
}
