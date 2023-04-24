package com.example.e01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.e01.domain.vo.TestVO;

@Mapper
public interface TestMapper {

	public List<TestVO> getList();
}

/*
	1. XML 쪽에 sql문을 작성한다
	2. 이 sql을  연결할 mapper 인터페이스가 있어야 함
	3. sql문과 mapper 인터페이스의 메소드가 연결이 되면 이 메소드를 사용할 때 연결된 쿼리가 실행되어 리턴되거나 파라미터를 보내줌
	
	==> 자바와 SQL이 분리된 형태이고 이를 갖춰주게 하는 것이 mybatis 프레임워크임
*/
