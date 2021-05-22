package com.ssafy.happyhouse.dto;

public class MapDto {
	@Override
	public String toString() {
		return "MapDto [longtitude=" + longtitude + ", latitude=" + latitude + "]";
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public MapDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MapDto(String longtitude, String latitude) {
		super();
		this.longtitude = longtitude;
		this.latitude = latitude;
	}
	private String longtitude; //경도
	private String latitude; //위도
}
