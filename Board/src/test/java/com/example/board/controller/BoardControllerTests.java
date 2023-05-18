package com.example.board.controller;

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
@WebAppConfiguration //WAS가 돌아가는 부분에 대해서 이 곳을 들렸다 가도록 함(즉 junit을 이용해 WAS가 돌아가면서 단위테스트를 할 수 있도록 함)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {

	@Autowired
	//WAS를 따로 쓰는 것이 아니라 불러와서 쓰기 때문에 사용함
	private WebApplicationContext webApplicationContext;  // context라는 영역을 써주는 것으로 설정들을 참고해서 빈들을 등록해 줄 수있는 컨테이너 즉, context라는 영역을 만들어줌 

	private MockMvc mockMvc; //파라미터 전달하고 get인지 post인지 결정하고 다양한 리턴 값들(경로)을 설정해주는 객체

	
	@Before
	public void setUp() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	/*
	@Test
	public void listTest() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());  //MockMvcRequestBuilders:요청을 할 수 있게끔 하는 거, andReturn(): 요청을 하고나서 결과들을 가져오는 객체, getModelAndView(): 현재 모델이란 객체에 뭐가 들어있는지 보여주는거
	
	}
	*/
	
	/*
	@Test
	public void registerTest() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				
				.param("title", "테스트 새 글 제목")
				.param("content", "테스트 새 글 내용")
				.param("writer","pjs")
				
				).andReturn().getFlashMap());  //getFlashMap: flashAttribute를 썼을 때 flash에 담겨져 있는 데이터를 가져오는거 
	}
	*/
	
	/*
	@Test
	public void readTest() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
			.param("bno","42")
				
		).andReturn().getModelAndView().getViewName()); // 	getViewName은 연산이 끝나고 실제로 이동하게 될 페이지의 경로,getModelMap을 쓰면 해당 게시물의 정보를 알 수 있음
	}
	*/
	
	/*
	@Test
	public void removeTests() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
				.param("bno", "61")
				
		).andReturn().getFlashMap());
	}
	*/
	
	/*
	
	@Test
	public void modifyTests() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
			.param("bno","62")
			.param("title", "엘링홀란드")
			.param("content","더브라위너")
			
		).andReturn().getFlashMap());		
		
	}
	*/
	
	@Test
	public void goModifyTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/board/modify").param("bno","62"));
	}
}
