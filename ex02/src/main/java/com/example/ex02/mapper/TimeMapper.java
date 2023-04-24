package com.example.ex02.mapper;

import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select;

/*
 * Mapper 인터페이스
 * 
 *  SQL를 작성하는 작업은 xml을 이용할 수도 있지만 최소한의 코드를 작성
 *  하기 위해서는 Mapper 인터페이스를 사용한다.
 */
@Mapper  //Mapper 도 Component 처럼 스캔을 해야하므로 rootContext에서 mybatis scan를 추가해줌
public interface TimeMapper {

	@Select("SELECT SYSDATE FROM DUAL") //간단한 쿼리는 이 처럼 사용하면 되지만 너무 긴 쿼리문은 XML을 이용하여 작성
	public String getTime();
	
	
	public String getTime2();
}
