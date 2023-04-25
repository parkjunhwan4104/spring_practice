<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX07</title>
</head>
<style>
	table{
		text-align: center;
	}
</style>

</head>
<body>
	<h1>ex07</h1>
	<c:set var="total" value="${studentVO.kor + studentVO.eng + studentVO.math}"/>
	<c:set var="avg" value="${total / 3}"/>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			
		</tr>
		<tr>
		
			<td><c:out value="${studentVO.num}"/> </td>   
			<td><c:out value="${studentVO.kor}"/> </td> 
			<td><c:out value="${studentVO.eng}"/> </td>
			<td><c:out value="${studentVO.math}"/> </td>   
			<td><c:out value="${total}점"/> </td> 
			<td><c:out value="${avg}점"/> </td>
		</tr>
	</table>	

</body>
</html>