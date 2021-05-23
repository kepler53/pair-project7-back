package com.ssafy.happyhouse.dto;

public class LegalCodeDto {

	private String legalCode;
	private String city;
	private String gu;
	private String dong;
	
	public String getLegalCode() {
		return legalCode;
	}
	public void setLegalCode(String legalCode) {
		this.legalCode = legalCode;
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
	@Override
	public String toString() {
		return "LegalCodeDto [legalCode=" + legalCode + ", city=" + city + ", gu=" + gu + ", dong=" + dong + "]";
	}
	public LegalCodeDto(String legalCode, String city, String gu, String dong) {
		super();
		this.legalCode = legalCode;
		this.city = city;
		this.gu = gu;
		this.dong = dong;
	}
	public LegalCodeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
