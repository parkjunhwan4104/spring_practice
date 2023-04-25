<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX04</title>
<style>
	table{
		text-align: center;
	}
</style>

</head>
<body>
	<h1>ex04</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<tr>
		<!--	<td><c:out value="${inforDTO.name}"/> </td>  //헌재 파일과 매핑되는 컨트롤러의 메소드에서 파라미터로 객체가 1개만 있으면 타입의 맨앞글자만 소문자로 바꾼 것이 key값으로 자동으로 설정됨    --> 
		<!--	<td><c:out value="${inforDTO.age}"/> </td> // inforDTO.getAge()가 아니고 그냥 age만 써도 inforDTO의 age필드의 getter 메소드를 알아서 찾아서 써줌  -->
			<td><c:out value="${dto.name}"/> </td>   
			<td><c:out value="${dto.age}"/> </td> 
		</tr>
	</table>	

</body>
</html>