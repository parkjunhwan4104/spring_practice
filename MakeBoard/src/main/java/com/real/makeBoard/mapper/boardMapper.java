package com.real.makeBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.real.makeBoard.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	public void add(BoardVO boardVO);
	
	public void modify(BoardVO boardVO);
	
	public void delete(Long bno);
	
	public BoardVO getOne(Long bno);
	
	public List<BoardVO> getList();
	
}
