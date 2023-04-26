<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마켓</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>상품명</th>
			<th>바코드 번호</th>
		</tr>
		
		<tr>
			<td>오땅</td>
			<td>11</td>
		</tr>
		<tr>
			<td>바나나우유</td>
			<td>22</td>
		</tr>
		<tr>
			<td>벌꿀 피자</td>
			<td>33</td>
		</tr>
		<tr>
			<td>치킨</td>
			<td>44</td>
		</tr>
	</table>
	
	<br>
	
	<form action="/cashier" method="post">
		<label>
		    상품 바코드 입력: <br>
			<input type="text" name="barcode">
		</label>
		<button>확인</button>
	</form>
	
	
</body>


</html>