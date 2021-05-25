package com.ssafy.happyhouse.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public String addBoard(BoardDto boardDto) throws Exception {
		
		int result = template.getMapper(BoardMapper.class).addBoard(boardDto);
		
		if(result>0) {
			return "성공";
		}else {
			throw new Exception();
		}

	}

	@Override
	public List<BoardDto> getBoardList() {
		
		List<BoardDto> bList = template.getMapper(BoardMapper.class).getBoardList();
		
		if(bList==null) {
			return null;
		}else {
			return bList;
		}
	}

}
