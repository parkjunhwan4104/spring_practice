package com.real.makeBoard.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.real.makeBoard.mapper.ReplyMapper;
import com.real.makeBoard.vo.ReplyVO;

@Repository
public class ReplyDAO {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	public boolean insert(ReplyVO replyVO) {
		return replyMapper.insert(replyVO)==1;
		
	}
	
	
	public boolean delete(Long rno) {
		return replyMapper.delete(rno)==1;
	}
	
	public List<ReplyVO> getListByBNO(Long bno) {
		
		return replyMapper.getListByBNO(bno);
	}
	
	public boolean modify(ReplyVO replyVO) {
		return replyMapper.modify(replyVO)==1;
	}
	
	public ReplyVO getReplyByRno(Long rno) {
		return replyMapper.getReplyByRno(rno);
	}
	
}
