package com.ssafy.happyhouse.dto;

import java.util.Date;

public class HouseDealDto {
	
	public HouseDealDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HouseDealDto(int no, String dong, String aptName, String code, String dealAmount, String buildYear,
			String floor, String jibun, String type, String rentMoney, Date registration, String lat, String lng) {
		super();
		this.no = no;
		this.dong = dong;
		this.aptName = aptName;
		this.code = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
		this.floor = floor;
		this.jibun = jibun;
		this.type = type;
		this.rentMoney = rentMoney;
		this.registration = registration;
		this.lat = lat;
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "HouseDealDto [no=" + no + ", dong=" + dong + ", aptName=" + aptName + ", code=" + code + ", dealAmount="
				+ dealAmount + ", buildYear=" + buildYear + ", floor=" + floor + ", jibun=" + jibun + ", type=" + type
				+ ", rentMoney=" + rentMoney + ", registration=" + registration + ", lat=" + lat + ", lng=" + lng + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
	public Date getRegistration() {
		return registration;
	}
	public void setRegistration(Date registration) {
		this.registration = registration;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	private int no;
	private String dong;
	private String aptName;
	private String code;
	private String dealAmount;
	private String buildYear;
	private String floor;
	private String jibun;
	private String type;
	
	private String area;
	private String rentMoney;
	private Date registration;
	private String lat;
	private String lng;
	
	

}
