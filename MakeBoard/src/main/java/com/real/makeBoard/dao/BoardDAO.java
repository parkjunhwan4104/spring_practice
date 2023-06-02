package com.real.makeBoard.dao;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.real.makeBoard.mapper.BoardMapper;
import com.real.makeBoard.vo.BoardVO;
import com.real.makeBoard.vo.Criteria;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void add(BoardVO board) {
		boardMapper.add(board);
		
	}
	
	public void modify(BoardVO boardVO) {
		boardMapper.modify(boardVO);
	}
	
	public void delete(Long bno){
		boardMapper.delete(bno);
	}
	
	public BoardVO getOne(Long bno) {
		return boardMapper.getOne(bno);
		
	}
	
	
	public List<BoardVO> getListByCriteria(Criteria criteria){
			return boardMapper.getListByCriteria(criteria);
	}
	
	public int getTotalNum(Criteria criteria) {
		return boardMapper.getTotalNum(criteria);
	}
	
	

}
