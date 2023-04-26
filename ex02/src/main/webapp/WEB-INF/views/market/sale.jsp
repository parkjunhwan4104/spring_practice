<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	
	<form action="/change" method="POST">
	
		<table border="1">
			<tr>
				<th>선택</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			
			<tr>
				<td>
					<input  type="radio" name="productNum" id="rd1" value="1" checked/>
					
				</td>
				<td>
					<label for="rd1">오땅</label><br/>
				</td>
				<td>4500</td>
			</tr>
			<tr>
				<td>
					<input  type="radio" name="productNum" id="rd2" value="2"/>
					
				</td>
				<td>
					<label for="rd2">바나나 우유</label><br/>
				</td>
				<td>1700</td>
			</tr>
			<tr>
				<td>
					<input  type="radio" name="productNum" id="rd3" value="3"/>
					
				</td>
				<td>
					<label for="rd3">피자</label><br/>
				</td>
				<td>24500</td>
			</tr>
			<tr>
				<td>
					<input  type="radio" name="productNum" id="rd4" value="4"/>
					
				</td>
				<td>
					<label for="rd4">치킨</label><br/>
				</td>
				<td>21500</td>
			</tr>
		</table>
		<br>


		할인율 선택: 
		<br>
		<input type="radio" name="salePercent" value="10">10%
		<input type="radio" name="salePercent" value="30" checked="checked">30%
		<input type="radio" name="salePercent" value="60">60%
		<input type="radio" name="salePercent" value="90">90%
	
		
        
        <button>적용</button>
	</form>

	

</body>
</html>