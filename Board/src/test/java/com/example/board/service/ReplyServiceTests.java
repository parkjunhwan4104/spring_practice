package com.example.board.service;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {

	@Autowired
	private ReplyService replyService; //현재 replyService에 지정된 것이 ReplyServiceImpl 밖에 없으므로 그냥 service로 쓰지만 여러개가 지정된 경우 qulifier을 사용해야함 
	
	private Long[] bnoArr= {3141L, 3134L, 3133L, 3132L,3131L};

	
	@Test
	public void serviceTest() {
		log.info(replyService);
	}
	
	/*
	@Test
	public void registerTest() {
		// 5개의 게시글에 2개씩 댓글 달기
		IntStream.rangeClosed(11, 20).forEach(i->{
			
			ReplyVO replyVO=new ReplyVO();
			replyVO.setBno(bnoArr[i%5]); //어떠한 범위를 나눌떄는 modules(%) 나머지를 통해 균일하게 나누는게 좋음 즉 5개의 게시물에 댓글을 달기 위해
			replyVO.setReply("댓글 테스트" +i);
			replyVO.setReplier("작성자 " + i);
			
			replyService.register(replyVO);
		});  // 총 10번 반복하여 특정 5개의 게시물에 댓글 2개씩달기
		
	}
	*/
	
	/*
	@Test
	public void findByRNOTest() {
		log.info(replyService.findByRNO(46L));
	}
	*/
	
	/*
	
	@Test
	public void removeByRNOTest() {
		log.info(replyService.removeByRNO(46L));
	}
	*/
	
	/*
	@Test
	public void removeAllByBNOTest() {
		log.info(replyService.removeAllByBNO(3133L));
	}
	*/
	
	
	/*
	@Test
	public void modifyTest() {
		ReplyVO replyVO=replyService.findByRNO(50L);
		
		if(replyVO!=null) {
			replyVO.setReply("펩 과르디올라");
		}
		
	
		log.info(replyVO==null?"읎어요.":replyService.modify(replyVO));
		
	}
	*/
	
	
	
	@Test
	public void findAllByBNOTest() {
		replyService.findAllByBNO(new Criteria(),3141L).forEach(log::info);
	}
	
	
}
