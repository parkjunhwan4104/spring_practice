package com.real.makeBoard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.makeBoard.dao.BoardDAO;
import com.real.makeBoard.vo.BoardVO;
import com.real.makeBoard.vo.Criteria;

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
		boardDAO.delete(bno);
	}
	
	public BoardVO getOne(Long bno) {
		return boardDAO.getOne(bno);
	}
	
	
	public List<BoardVO> getListByCriteria(Criteria criteria){
		return boardDAO.getListByCriteria(criteria);
	}
	
	public int getTotalNum(Criteria criteria) {
		return boardDAO.getTotalNum(criteria);
	}
	
	
	
	
}
