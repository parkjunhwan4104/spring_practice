<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 결제</title>
</head>
<body>
	
	
	
	
	<form action="/use" method="POST">
		<input type="hidden" name="saledProductName" value="${productName}">
		<input type="hidden" name="saledProductPrice" value="${productPrice}">
		<input type="hidden" name="saledProductNumber" value="${productNumber}">
		
		<table border="1" style="margin:0 auto;">
			<tr>
				<th>선택</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			
			<tr>
				<td>
					<input  type="radio" name="productNum" id="rd1" value="1" />
					
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
		<div style="text-align: center;">
			<input type="text" name="point" placeholder="사용하실 포인트를 입력하세요" style="width:200px;">
			<input type="submit" value="구매">
		</div>



	</form>

	

</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

	//아래 자바스크립트 코드는 포인트로 할인된 상품을 구매하기 위해서 할인율이 적용된 상품이 무엇인지 알려주고(빨간색으로) 해당 가격을 할인된 가격으로 바꿔줌


	let productNumber="${productNumber}";
	let productPrice= "${productPrice}";
	
	$(document).ready(function(){
		$("input[name='productNum']").each(function(i, input){
			if($(input).val() == productNumber){
				const priceTag = $(input).closest("tr").children()[2];
				const trTag = $(input).closest("tr");
				
				$(trTag).css("background-color", "red");
				$(trTag).css("color", "white");
				$(priceTag).text(productPrice);
			}
		});
	});
</script>

</html>