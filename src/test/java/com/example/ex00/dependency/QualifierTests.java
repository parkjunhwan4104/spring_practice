package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.ex00.dependency.qualifier.Computer;
import com.example.ex00.dependency.qualifier.Outback;

import lombok.extern.log4j.Log4j;

import com.example.ex00.dependency.qualifier.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)

//run할 때 해당 파일을 참조해서 돌아가도록 함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QualifierTests {
	
	@Autowired
	@Qualifier("laptop") //퀄리파이어는 같은 타입이 여러개일때 내가 원하는 객체를 받기 위해 사용함
	private Computer computer;
	
	//laptop을 더 많이 사용하여 laptop을 디폴트로 주입받고 싶을 때 laptop에 @Primary 붙이고 아래 실행
	 @Autowired
	 private Computer com;
	 
	@Autowired
	@Qualifier("outback")
	private Restaurant outback;
	
	@Autowired
	private Restaurant vips;
	
	@Test
	public void testQualifier() {
		log.info("--------------------");
		
		log.info("computer: "+computer);
		log.info("screenWidth: "+computer.getScreenWidth());
		log.info("--------------------");
		
		log.info("--------------------");
		
		log.info("computer: "+com);
		log.info("screenWidth: "+com.getScreenWidth());
		log.info("--------------------");
		
		
		
		log.info("--------------------");
		
		log.info("outback: "+outback);
		log.info("sidebar: "+outback.hasSaladbar());
		log.info("steakPrice: "+Outback.steak);
		log.info("--------------------");
		
		log.info("--------------------");
		
		log.info("vips: "+vips);
		log.info("sidebar: "+vips.hasSaladbar());
		log.info("steakPrice: "+Restaurant.steak);
		log.info("--------------------");
		
	}

}
