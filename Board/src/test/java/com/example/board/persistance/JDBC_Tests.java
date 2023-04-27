package com.example.board.persistance;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)


@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBC_Tests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","d201902695","wnsghks2769")){
			log.info(connection);
		}
		catch(Exception e) {
			//JUnit의 메소드로서, 무조건 실패로 처리한뒤 실행을 중지한다.
			fail(e.getMessage());
		}
	}

}
