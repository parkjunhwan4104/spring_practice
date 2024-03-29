package com.example.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileVO;

@Service
public interface BoardService { //service의 역할: 여러개의 dao를 한 번에 묶어서 사용할 수 있음
	//게시글 등록
	public void register(BoardDTO boardDTO);
	
	//특정 게시글 가져오기
	public BoardVO get(Long bno);
	
	//게시글 수정
	public boolean modify(BoardVO boardVO);
	
	//게시글 삭제
	public boolean remove(Long bno);
	
	//전체 게시글 가져오기
	public List<BoardVO> getList(Criteria criteria);

	//전체 게시물 개수
	public int getTotal(Criteria criteria);
	
	public List<FileVO> getFiles(Long bno);
 }
