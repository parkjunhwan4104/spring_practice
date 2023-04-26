<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품명 확인</title>
</head>
<body>
    <h1><c:out value="해당 상품은 ${productName}입니다." /></h1>

</body>
</html>