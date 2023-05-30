package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService { //코드를 재사용하고 결합을 느슨하게 하기위해 인터페이스를 사용함, 재사용하지 않으면 단순히 클래스로만 구현함

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public void register(BoardDTO boardDTO) {
		boardDAO.register(boardDTO);
	}

	@Override
	public BoardVO get(Long bno) {
			
		return boardDAO.get(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		return boardDAO.modify(boardVO);  //업데이트가 되었을 때 true
	}

	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);  //delete가 되었으면 true
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		
		return boardDAO.getList(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		
		return boardDAO.getTotal(criteria);
	}

}
