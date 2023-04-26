<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출근 체크인</title>
</head>
<body>
	<form action="/getToWork" name="checkInForm" method="get">
		<input type="text" name="name" required>
		<br>
		<button >출근</button>
		<button type="button">퇴근</button>
	</form>
	
	
</body>

<script>
	let form=checkInForm;
	let button = document.querySelector("button[type='button']");
	button.addEventListener("click", function(){
		form.setAttribute("action","/leaveWork");
		form.submit();
	})
	//console.log(form.getAttribute("action"));
	
</script>
</html>