package com.example.e01.persistance;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

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
public class DataSouceTests {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection conn=dataSource.getConnection()){
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
}
