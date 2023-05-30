package com.example.board.domain.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileVO;
import com.example.board.mapper.BoardMapper;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void register(BoardDTO board) {
		// TODO Auto-generated method stub
		boardMapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return boardMapper.getOne(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return boardMapper.update(board)!=0;
	}

	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno)!=0;
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		
		return boardMapper.getTotal(criteria);
	}

	@Override
	public List<FileVO> getFiles(Long bno) {
				
		return boardMapper.getFiles(bno);
	}
	
	

}
