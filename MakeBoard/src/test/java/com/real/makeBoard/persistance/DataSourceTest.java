package com.real.makeBoard.persistance;

import static org.junit.Assert.fail; 

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.real.makeBoard.persistance.DataSourceTest;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void conntectionTest() {
		
		
		try {
			SqlSession sqlSession=sqlSessionFactory.openSession(true);
			Connection conn=sqlSession.getConnection();
			
			log.info(sqlSession);
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
		
		
		/*
		try(Connection connection=dataSource.getConnection()){
			log.info(connection);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		*/
	}

}
