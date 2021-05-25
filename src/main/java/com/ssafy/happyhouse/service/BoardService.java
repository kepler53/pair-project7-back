package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardService {
	
	public String addBoard(BoardDto boardDto) throws Exception;
	
	public List<BoardDto> getBoardList();
}
