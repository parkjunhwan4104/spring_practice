package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardVO;

@Service
public interface BoardService {
	//게시글 등록
	public void register(BoardVO boardVO);
	
	//특정 게시글 가져오기
	public BoardVO get(Long bno);
	
	//게시글 수정
	public boolean modify(BoardVO boardVO);
	
	//게시글 삭제
	public boolean remove(Long bno);
	
	//전체 게시글 가져오기
	public List<BoardVO> getList();
}
