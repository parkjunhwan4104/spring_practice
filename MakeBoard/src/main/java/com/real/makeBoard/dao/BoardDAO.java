package com.real.makeBoard.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.real.makeBoard.mapper.BoardMapper;
import com.real.makeBoard.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void add(BoardVO board) {
		boardMapper.add(board);
		
	}
	
	public void modify(Long bno) {
		
	}
	
	public void delete(Long bno){
		
	}
	
	public void getOne(Long bno) {
		
	}
	
	
	public List<BoardVO> getList(){
			return boardMapper.getList();
	}
	

}
