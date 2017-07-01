package com.kosenin.weatherapp2;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kosenin.weatherapp2.Helpers.ListItem;
import com.kosenin.weatherapp2.Helpers.Weather;
import com.kosenin.weatherapp2.Helpers.WeatherData;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static java.lang.System.load;

/**
 * Created by Konstantin2 on 29.06.2017.
 */

public class Forecast5DaysAdapter extends RecyclerView.Adapter<Forecast5DaysAdapter.ForecastHolder> {


    List<ListItem> listItemList;


    public static class ForecastHolder extends RecyclerView.ViewHolder {

        public TextView dateOnDate;
        public ImageView weatherOnDate;
        public TextView tempOnDate;
        public TextView windSpeedOnDate;

        public ForecastHolder(View view) {
            super(view);

            dateOnDate = (TextView) view.findViewById(R.id.dateOnDate);
            windSpeedOnDate = (TextView) view.findViewById(R.id.windSpeedOnDate);
            tempOnDate = (TextView) view.findViewById(R.id.tempOnDate);
            weatherOnDate = (ImageView) view.findViewById(R.id.imageOnDate);


        }
    }

    public Forecast5DaysAdapter(List<ListItem> listItemList) {

        this.listItemList = listItemList;
    }

    @Override
    public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_card, parent, false);

        final ForecastHolder forecastHolder = new ForecastHolder(view);

        return forecastHolder;
    }

    @Override
    public void onBindViewHolder(ForecastHolder holder, int position) {

        //FILLING THE CARDS IN RECYCLERVIEW WITH INFORMATION

        long milliseconds = listItemList.get(position).getDt();
        Date d = new Date(milliseconds * 1000);
        SimpleDateFormat simpleData = new SimpleDateFormat("dd.MM.yyyy kk:mm ");
        String date = simpleData.format(d);

        int temperatureRounded = (int) Math.round(listItemList.get(position).getMain().getTemp());
        String temp = String.valueOf(temperatureRounded);
        int windRounded = (int) Math.round(listItemList.get(position).getWind().getSpeed());


        holder.dateOnDate.setText(String.valueOf(date));
        holder.tempOnDate.setText(String.valueOf(temp) + "°C");
        holder.windSpeedOnDate.setText(String.valueOf(windRounded + " м/с"));
        Glide.with(holder.weatherOnDate.getContext()).load("http://openweathermap.org/img/w/" + listItemList.get(position).getWeather().get(0).getIcon() + ".png").fitCenter().into(holder.weatherOnDate);


    }


    @Override
    public int getItemCount() {
        return listItemList.size();
    }
}
