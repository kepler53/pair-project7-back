package com.ssafy.happyhouse.service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardService {
	
	public String addBoard(BoardDto boardDto) throws Exception;
	
	public List<BoardDto> getBoardList();

	public BoardDto getBoard(int no);

	public String updateBoard(BoardDto boardDto) throws Exception;

	public String deleteBoard(String no) throws Exception;
}
