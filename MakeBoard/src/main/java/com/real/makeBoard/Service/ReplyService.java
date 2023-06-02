package com.real.makeBoard.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.makeBoard.dao.ReplyDAO;
import com.real.makeBoard.vo.ReplyVO;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	public void insert(ReplyVO replyVO) {
		replyDAO.insert(replyVO);
	}
	
	public void delete(Long rno) {
		replyDAO.delete(rno);
	}
	
	public List<ReplyVO> getListByBNO(Long bno) {
		
		return replyDAO.getListByBNO(bno);
	}
	
	public void modify(ReplyVO replyVO) {
		replyDAO.modify(replyVO);
	}
	
	public ReplyVO getReplyByRno(Long rno) {
		return replyDAO.getReplyByRno(rno);
	}

}
