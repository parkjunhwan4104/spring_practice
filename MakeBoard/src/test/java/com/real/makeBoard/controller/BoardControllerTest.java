package com.real.makeBoard.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/*
	@Test
	public void doAddTest() {
		try {
			log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/add")
					
					.param("title", "테스트 새 글 제목")
					.param("content", "테스트 새 글 내용")
					.param("writer","pjs")
					
					).andReturn().getModelAndView().getModelMap());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	*/
	
	/*
	@Test
	public void getListTest() {
		try {
			log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
					.andReturn().getModelAndView().getModelMap());
				
												
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	*/
	
	/*
	@Test
	public void getOneTest() {
		try {
			log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/detail/4")).andReturn().getModelAndView().getModelMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	/*
	@Test
	public void modifyTest() {
		try {
			log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
					.param("title", "맨시티")
					.param("content", "홀란드")
									
					).andReturn().getModelAndView().getModelMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	
	
	
	
}
