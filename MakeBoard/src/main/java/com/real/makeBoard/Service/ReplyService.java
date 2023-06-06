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
	
	public boolean insert(ReplyVO replyVO) {
		return replyDAO.insert(replyVO);
	}
	
	public boolean delete(Long rno) {
		return replyDAO.delete(rno);
	}
	
	public List<ReplyVO> getListByBNO(Long bno) {
		
		return replyDAO.getListByBNO(bno);
	}
	
	public boolean modify(ReplyVO replyVO) {
		return replyDAO.modify(replyVO);
	}
	
	public ReplyVO getReplyByRno(Long rno) {
		return replyDAO.getReplyByRno(rno);
	}

}
