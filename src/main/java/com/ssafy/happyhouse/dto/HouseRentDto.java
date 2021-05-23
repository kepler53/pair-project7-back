package com.ssafy.happyhouse.dto;

public class HouseRentDto {
	
	
	private int houserent_no;
	private String houserent_gu;
	private String houserent_dong;
	private String houserent_name;
	private String houserent_floor;
	private String houserent_buildtype;
	private String houserent_area;
	private String houserent_type;
	private String houserent_deposit;
	private String houserent_fee;
	private String houserent_buildYear;
	private String registration;
	public int getHouserent_no() {
		return houserent_no;
	}
	public void setHouserent_no(int houserent_no) {
		this.houserent_no = houserent_no;
	}
	public String getHouserent_gu() {
		return houserent_gu;
	}
	public void setHouserent_gu(String houserent_gu) {
		this.houserent_gu = houserent_gu;
	}
	public String getHouserent_dong() {
		return houserent_dong;
	}
	public void setHouserent_dong(String houserent_dong) {
		this.houserent_dong = houserent_dong;
	}
	public String getHouserent_name() {
		return houserent_name;
	}
	public void setHouserent_name(String houserent_name) {
		this.houserent_name = houserent_name;
	}
	public String getHouserent_floor() {
		return houserent_floor;
	}
	public void setHouserent_floor(String houserent_floor) {
		this.houserent_floor = houserent_floor;
	}
	public String getHouserent_buildtype() {
		return houserent_buildtype;
	}
	public void setHouserent_buildtype(String houserent_buildtype) {
		this.houserent_buildtype = houserent_buildtype;
	}
	public String getHouserent_area() {
		return houserent_area;
	}
	public void setHouserent_area(String houserent_area) {
		this.houserent_area = houserent_area;
	}
	public String getHouserent_type() {
		return houserent_type;
	}
	public void setHouserent_type(String houserent_type) {
		this.houserent_type = houserent_type;
	}
	public String getHouserent_deposit() {
		return houserent_deposit;
	}
	public void setHouserent_deposit(String houserent_deposit) {
		this.houserent_deposit = houserent_deposit;
	}
	public String getHouserent_fee() {
		return houserent_fee;
	}
	public void setHouserent_fee(String houserent_fee) {
		this.houserent_fee = houserent_fee;
	}
	public String getHouserent_buildYear() {
		return houserent_buildYear;
	}
	public void setHouserent_buildYear(String houserent_buildYear) {
		this.houserent_buildYear = houserent_buildYear;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	@Override
	public String toString() {
		return "HouseRentDto [houserent_no=" + houserent_no + ", houserent_gu=" + houserent_gu + ", houserent_dong="
				+ houserent_dong + ", houserent_name=" + houserent_name + ", houserent_floor=" + houserent_floor
				+ ", houserent_buildtype=" + houserent_buildtype + ", houserent_area=" + houserent_area
				+ ", houserent_type=" + houserent_type + ", houserent_deposit=" + houserent_deposit + ", houserent_fee="
				+ houserent_fee + ", houserent_buildYear=" + houserent_buildYear + ", registration=" + registration
				+ "]";
	}
	public HouseRentDto(int houserent_no, String houserent_gu, String houserent_dong, String houserent_name,
			String houserent_floor, String houserent_buildtype, String houserent_area, String houserent_type,
			String houserent_deposit, String houserent_fee, String houserent_buildYear, String registration) {
		super();
		this.houserent_no = houserent_no;
		this.houserent_gu = houserent_gu;
		this.houserent_dong = houserent_dong;
		this.houserent_name = houserent_name;
		this.houserent_floor = houserent_floor;
		this.houserent_buildtype = houserent_buildtype;
		this.houserent_area = houserent_area;
		this.houserent_type = houserent_type;
		this.houserent_deposit = houserent_deposit;
		this.houserent_fee = houserent_fee;
		this.houserent_buildYear = houserent_buildYear;
		this.registration = registration;
	}
	public HouseRentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
