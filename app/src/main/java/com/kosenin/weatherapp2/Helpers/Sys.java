package com.kosenin.weatherapp2.Helpers;


import com.google.gson.annotations.SerializedName;


public class Sys{

	@SerializedName("pod")
	private String pod;

	public void setPod(String pod){
		this.pod = pod;
	}

	public String getPod(){
		return pod;
	}
}