package com.example.ex00.dependency;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

//run할 때 해당 파일을 참조해서 돌아가도록 함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DependencyTests {
	@Autowired
	private Coding coding;
	
	@Autowired
	private Restaurant rest;
	
	/*@Test
	public void checkDependencyInjection() {
		log.info("--------------------");
		log.info("coding: "+coding);
		log.info("computer: "+coding.getComputer());
		log.info("--------------------");		
	}
	*/	
	@Test
	public void checkDependencyInjection() {
		log.info("--------------------");
		log.info("rest: "+rest);
		log.info("chef: "+rest.getChef());
		log.info("--------------------");
	}
}
