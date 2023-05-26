package com.example.board.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.dao.ReplyDAO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service

public interface ReplyService {
	
	public boolean register(ReplyVO replyVO);	
	
	public ReplyVO findByRNO(Long rno);
	
	public boolean removeByRNO(Long rno);
	
	public boolean modify(ReplyVO replyVO);

	public boolean removeAllByBNO(Long bno); 
	
	public List<ReplyVO> findAllByBNO(Criteria criteria,Long bno);

}
