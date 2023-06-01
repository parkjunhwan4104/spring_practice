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
	
	public void modify(BoardVO boardVO) {
		boardDAO.modify(boardVO);
		
	}
	
	public void delete(Long bno) {
		
	}
	
	public BoardVO getOne(Long bno) {
		return boardDAO.getOne(bno);
	}
	
	
	public List<BoardVO> getList(){
		return boardDAO.getList();
	}
	
}
