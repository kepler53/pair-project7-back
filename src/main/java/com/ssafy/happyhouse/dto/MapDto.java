package com.ssafy.happyhouse.dto;

public class MapDto {
	
	

	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "MapDto [lng=" + lng + ", lat=" + lat + "]";
	}
	public MapDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String lng; //경도
	public MapDto(String lng, String lat) {
		super();
		this.lng = lng;
		this.lat = lat;
	}
	private String lat; //위도
}
