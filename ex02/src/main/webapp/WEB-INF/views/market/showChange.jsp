<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할인 가격</title>
</head>
<body>

  <h1><c:out value="상품 ${name}의 할인된 가격은 ${price}입니다." /></h1>

  <form action="/usePoint" method="post" name="discountForm">
  	<input type="hidden" name="productName" value="${name}">
  	<input type="hidden" name="productNumber" value="${num}">
  	<input type="hidden" name="productPrice" value="${price}">
  	<input type="submit" value="포인트를 사용하여 상품 구매하러 가기" style="display:block; margin:0 auto;">
  
  </form>	
  
  <input type="button" onclick="location.href='/sale'" value="상품 및 할인율 변경하기" style="display:block; margin:0 auto;">

</body>
</html>