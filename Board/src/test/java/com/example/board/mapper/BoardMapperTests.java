package com.example.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	/*
	@Test
	public void getListTest() {
		boardMapper.getList().forEach(log::info);
	}
	*/
	
	
	/*
	@Test
	public void insertTest() {
		BoardVO board=new BoardVO();
		board.setTitle("새로 작성한 글 제목");
		board.setContent("새로 작성한 글 내용");
		board.setWriter("user04");
		
		boardMapper.insert(board);
		
		log.info(board);
	}
	*/
	
	/*
	@Test
	public void getOneTest() {
		BoardVO boardVo=boardMapper.getOne(5L); //5L은 5의 Long 타입
		log.info(boardVo);
	}
	*/
	
	/*
	@Test
	public void deleteOneTest() {
		Long bno=5L;
		if(boardMapper.getOne(bno)!=null) {
			log.info("DELETE COUNT :"+boardMapper.delete(bno)); //삭제된 건수 출력
			return;
		}
		
		log.info("NO BOARD");
	}
	*/
	
	
	
}
