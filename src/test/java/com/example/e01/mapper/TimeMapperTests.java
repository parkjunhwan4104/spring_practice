package com.example.e01.mapper;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.e01.persistance.JDBC_Tests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

//run할 때 해당 파일을 참조해서 돌아가도록 함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	private TimeMapper timeMapper;

	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	/*
	@Test
	public void testGetTime2() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime2());
	}
	*/
}
