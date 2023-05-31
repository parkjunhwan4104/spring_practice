package com.real.makeBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.real.makeBoard.vo.BoardVO;

@Mapper
public interface boardMapper {
	
	public void add();
	
	public void modify(Long bno);
	
	public void delete(Long bno);
	
	public BoardVO getOne(Long bno);
	
	public List<BoardVO> getList();
	
}
