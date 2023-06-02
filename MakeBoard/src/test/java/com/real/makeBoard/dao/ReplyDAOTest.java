package com.real.makeBoard.dao;

import java.util.stream.IntStream; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.real.makeBoard.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyDAOTest {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	private Long[] bnoArr= {2L,4L, 7L, 8L,9L};
	
	/*
	@Test
	public void insertTest() {
		
		
		ReplyVO replyVO=new ReplyVO();
		
		replyVO.setBno(2L);
		replyVO.setReplyContent("니게");
		replyVO.setWriter("정승룡");
		
		replyDAO.insert(replyVO);
		
		
		IntStream.rangeClosed(1, 10).forEach(i->{
			
			ReplyVO replyVO=new ReplyVO();
			replyVO.setBno(bnoArr[i%5]); //어떠한 범위를 나눌떄는 modules(%) 나머지를 통해 균일하게 나누는게 좋음 즉 5개의 게시물에 댓글을 달기 위해
			replyVO.setReplyContent("댓글 테스트" +i);
			replyVO.setWriter("작성자 " + i);
			
			replyDAO.insert(replyVO);
		});  // 총 10번 반복하여 특정 5개의 게시물에 댓글 2개씩달기
	}
	*/
	/*
	@Test
	public void deleteTest() {
		replyDAO.delete(1L);
	}
	*/
	
	/*
	@Test
	public void modifyTest() {
		ReplyVO replyVO=replyDAO.getReplyByRno(1L);
		
		if(replyVO!=null) {
			replyVO.setReplyContent("아임그루트");
			replyDAO.modify(replyVO);
		}
		else {
			log.info("해당 답글이 없습니다.");
		}
		
		
	}
	*/
	
	@Test
	public void getListByBnoTest() {
		replyDAO.getListByBNO(9L).forEach(log::info);
	}
	

}
