package com.ssafy.happyhouse.dto;

public class BoardDto {
	

	private String title;
	private String board_regdate;
	private String content;
	private String user_id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "BoardDto [title=" + title + ", board_regdate=" + board_regdate + ", content=" + content + ", user_id="
				+ user_id + ", getTitle()=" + getTitle() + ", getBoard_regdate()=" + getBoard_regdate()
				+ ", getContent()=" + getContent() + ", getUser_id()=" + getUser_id() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public BoardDto(String title, String board_regdate, String content, String user_id) {
		super();
		this.title = title;
		this.board_regdate = board_regdate;
		this.content = content;
		this.user_id = user_id;
	}
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
