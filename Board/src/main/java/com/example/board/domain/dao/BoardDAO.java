package com.example.board.domain.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileVO;

@Repository
public interface BoardDAO {
	
	public void register(BoardDTO boardDTO);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList(Criteria criteria);

	public int getTotal(Criteria criteria);
	
	public List<FileVO> getFiles(Long bno);
}
