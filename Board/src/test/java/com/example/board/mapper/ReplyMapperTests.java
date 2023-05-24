package com.example.board.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr= {3141L, 3134L, 3133L, 3132L,3131L};

	@Autowired
	private ReplyMapper replyMapper;
	
	/*
	@Test
	public void mapperTest() {
		log.info(replyMapper);
	}
	*/
	
	/*
	@Test
	public void insertTest() {
		// 5개의 게시글에 2개씩 댓글 달기
		IntStream.rangeClosed(1, 10).forEach(i->{
			
			ReplyVO replyVO=new ReplyVO();
			replyVO.setBno(bnoArr[i%5]); //어떠한 범위를 나눌떄는 modules(%) 나머지를 통해 균일하게 나누는게 좋음 즉 5개의 게시물에 댓글을 달기 위해
			replyVO.setReply("댓글 테스트" +i);
			replyVO.setReplier("작성자 " + i);
			
			replyMapper.insert(replyVO);
		});  // 총 10번 반복하여 특정 5개의 게시물에 댓글 2개씩달기
		
	}
	*/
	
	/*
	
	@Test
	public void selectTest() {
		log.info(replyMapper.select(10L));
	}
	*/
	
	/*
	@Test
	public void deleteTest() {
		log.info(replyMapper.delete(8L));
	}
	*/
	
	/*
	@Test
	public void deleteAllTest() {
		log.info(replyMapper.deleteAll(3134L));
	}
	*/
	
	@Test
	public void updateTest() {
		ReplyVO replyVO=replyMapper.select(1L);
		
		if(replyVO!=null) {
			replyVO.setReply("수정된 내용이여~");
		}
		
	
		log.info(replyVO==null? "없는 댓글입니다.": replyMapper.update(replyVO)+"건 수정되었습니다.");
		
		
		
	}
	
	
	
}
