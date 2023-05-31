package com.real.makeBoard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.makeBoard.dao.BoardDAO;
import com.real.makeBoard.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public void add(BoardVO boardVO) {
		boardDAO.add(boardVO);
		
	}
	
	public void modify(Long bno) {
		
	}
	
	public void delete(Long bno) {
		
	}
	
	public void getOne(Long bno) {
		
	}
	
	
	public List<BoardVO> getList(){
		return boardDAO.getList();
	}
	
}
