package com.kosenin.weatherapp2.Helpers;

import android.content.Intent;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WeatherData{
	@SerializedName("coord")
	@Expose
	private Coord coord;
	@SerializedName("weather")
	@Expose
	private List<Weather> weather = null;
	@SerializedName("base")
	@Expose
	private String base;
	@SerializedName("main")
	@Expose
	private Main main;
	@SerializedName("visibility")
	@Expose
	private Integer visibility;
	@SerializedName("wind")
	@Expose
	private Wind wind;
	@SerializedName("clouds")
	@Expose
	private Clouds clouds;
	@SerializedName("dt")
	@Expose
	private Long dt;
	@SerializedName("sys")
	@Expose
	private Sys sys;
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("city")
	private City city;

	@SerializedName("cnt")
	private int cnt;


	@SerializedName("message")
	private double message;

	@SerializedName("list")
	private List<ListItem> list;

	@SerializedName("cod")
	@Expose
	private Integer cod;

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setCnt(int cnt){
		this.cnt = cnt;
	}

	public int getCnt(){
		return cnt;
	}



	public void setMessage(double message){
		this.message = message;
	}

	public double getMessage(){
		return message;
	}

	public void setList(List<ListItem> list){
		this.list = list;
	}

	public List<ListItem> getList(){
		return list;
	}



	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

}