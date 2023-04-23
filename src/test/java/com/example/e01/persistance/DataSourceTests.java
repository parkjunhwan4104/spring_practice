package com.example.e01.persistance;

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

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

//run할 때 해당 파일을 참조해서 돌아가도록 함
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {  
		
		try(
			SqlSession sqlsession=sqlSessionFactory.openSession(true);
			Connection conn=sqlsession.getConnection();
		){
			log.info(sqlsession);
			log.info(conn);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		
		/* dataSource를 통해 커낵션 객체를 가져올 수 있음
		try(Connection connection=datasource.getConnection()){
			log.info(connection);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		*/
	}
	
	//persistence 영역에서 Xml에서 SQL문을 작성하고 인터페이스(처음에는 구현이 안되어 있음)를 만드는 쪽이 자바임 
	// 하지만 XML에 있는 쿼리를 실행되면서 인터페이스안이 구현이 됨 
	// 우리가 자바쪽에서 이 인터페이스에 있는 추상메소드를 사용하면 인터페이스 어느 메소드에 바인딩이 된 해당 SQL문이 실행되어 분리한 다음 합쳐서 실행하게됨
	// 이러한 인터페이스를 Mapper라고 함
}
