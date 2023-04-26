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

</body>
</html>