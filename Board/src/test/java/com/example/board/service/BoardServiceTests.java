package com.example.board.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;
import com.example.board.mapper.BoardMapperTests;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService boardService; //boardService를 구현한 객체(BoardServiceImpl)가 빈 컨테이너에 등록이 되어있으면 그 객체가 주입이 됨. 
	
	/*
	@Test
	public void serviceTest() {
		log.info(boardService);
	}
	*/
	
	/*
	@Test
	public void registerTest() {
		BoardVO board=new BoardVO();
		board.setTitle("new title");
		board.setContent("new content");
		board.setWriter("user05");
		
		boardService.register(board);
		
		log.info("생성된 게시글 번호: "+board.getBno());
	}
	*/
	
	/*
	@Test
	public void getTest() {
		BoardVO board=boardService.get(5L);
		if(board!=null) {
			log.info(board);
			return;
		}
		log.info("No Board");
	}
	*/
	
	/*
	@Test
	public void modifyTest() {
		BoardVO board=boardService.get(0L);
		if(board==null) { // 해당 게시판이 없을 경우 널 포인트 에러를 막기 위해
			log.info("NO BOARD");
			return;
		}
		board.setTitle("신규 등록");
		board.setContent("새로 등록된 내용입니다.");
		
		if(boardService.modify(board)) {
			log.info("UPDATE SUCCESS");
			return;
		}
		log.info("UPDATE FAILURE");
	}
	*/
	
	
	/*
	@Test
	public void removeTest() {
		BoardVO board=boardService.get(4L);
		if(board==null) {
			log.info("NO BOARD");
			return;
		}
		
		if(boardService.remove(board.getBno())) {
			log.info("REMOVE SUCCESS");
			return;
		}
		log.info("REMOVE FAILURE");
	}
	*/
	
	@Test
	public void getListTest() {
		boardService.getList().forEach(log::info);
	}
	
	
	
}
