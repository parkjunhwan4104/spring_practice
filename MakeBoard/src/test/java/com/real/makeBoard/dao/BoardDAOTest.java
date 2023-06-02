package com.real.makeBoard.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.real.makeBoard.vo.Criteria;
import com.real.makeBoard.persistance.DataSourceTest;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDAOTest {
	
	@Autowired
	private BoardDAO boardDAO;
	
	/*
	@Test
	public void getTotal() {
		log.info(boardDAO.getTotalNum());
	}
	*/
	
	
	
	@Test
	public void getListByCriteria() {
		boardDAO.getListByCriteria(new Criteria(8,8,"트","TW")).forEach(log::info);
	}
	

}
