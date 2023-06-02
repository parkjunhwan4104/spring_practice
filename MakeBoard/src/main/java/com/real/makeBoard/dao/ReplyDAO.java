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
	
	public void insert(ReplyVO replyVO) {
		replyMapper.insert(replyVO);
		
	}
	
	
	public void delete(Long rno) {
		replyMapper.delete(rno);
	}
	
	public List<ReplyVO> getListByBNO(Long bno) {
		
		return replyMapper.getListByBNO(bno);
	}
	
	public void modify(ReplyVO replyVO) {
		replyMapper.modify(replyVO);
	}
	
	public ReplyVO getReplyByRno(Long rno) {
		return replyMapper.getReplyByRno(rno);
	}
	
}
