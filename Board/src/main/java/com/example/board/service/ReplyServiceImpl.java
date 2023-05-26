package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.dao.ReplyDAO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private final ReplyDAO replyDAO;
	
	@Override
	public boolean register(ReplyVO replyVO) {
		
		return replyDAO.register(replyVO);
	}

	@Override
	public ReplyVO findByRNO(Long rno) {
		
		return replyDAO.findByRNO(rno);
	}

	@Override
	public boolean removeByRNO(Long rno) {
	
		return replyDAO.removeByRNO(rno);
	}

	@Override
	public boolean modify(ReplyVO replyVO) {
		
		return replyDAO.modify(replyVO);
	}

	@Override
	public boolean removeAllByBNO(Long bno) {
		
		return replyDAO.removeAllByBNO(bno);
	}

	@Override
	public List<ReplyVO> findAllByBNO(Criteria criteria,Long bno) {
		
		return replyDAO.findAllByBNO(criteria,bno);
	}

}
