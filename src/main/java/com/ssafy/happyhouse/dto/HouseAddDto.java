package com.ssafy.happyhouse.dto;

public class HouseAddDto {
	private String city;
	private String gu;
	private String dong;
	private String area;
	private String deposit;
	private String fee;
	private String buildYear;
	private String floor;
	private String aptName;
	
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
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
	@Override
	public String toString() {
		return "HouseAddDto [city=" + city + ", gu=" + gu + ", dong=" + dong + ", area=" + area + ", deposit=" + deposit
				+ ", fee=" + fee + ", buildYear=" + buildYear + ", floor=" + floor + "]";
	}

	public HouseAddDto(String city, String gu, String dong, String area, String deposit, String fee, String buildYear,
			String floor) {
		super();
		this.city = city;
		this.gu = gu;
		this.dong = dong;
		this.area = area;
		this.deposit = deposit;
		this.fee = fee;
		this.buildYear = buildYear;
		this.floor = floor;
	}
	public HouseAddDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
