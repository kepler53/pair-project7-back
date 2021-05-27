package com.ssafy.happyhouse.dto;

public class ConvenienceDto {
	
	private int no;
	private int coffee;
	private int convenience;
	private int school;
	private int cctv;
	private int police;
	private int station;
	public int getStation() {
		return station;
	}
	public void setStation(int station) {
		this.station = station;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCoffee() {
		return coffee;
	}
	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}
	public int getConvenience() {
		return convenience;
	}
	public void setConvenience(int convenience) {
		this.convenience = convenience;
	}
	public int getSchool() {
		return school;
	}
	public void setSchool(int school) {
		this.school = school;
	}
	public int getCctv() {
		return cctv;
	}
	public void setCctv(int cctv) {
		this.cctv = cctv;
	}
	public int getPolice() {
		return police;
	}
	public void setPolice(int police) {
		this.police = police;
	}
	public ConvenienceDto(int no, int coffee, int convenience, int school, int cctv, int police) {
		super();
		this.no = no;
		this.coffee = coffee;
		this.convenience = convenience;
		this.school = school;
		this.cctv = cctv;
		this.police = police;
	}
	public ConvenienceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ConvenienceDto [no=" + no + ", coffee=" + coffee + ", convenience=" + convenience + ", school=" + school
				+ ", cctv=" + cctv + ", police=" + police + "]";
	}

}
