<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />
</head>
<body>
	<form action="/board/add" method="POST">
		<div>
			<h4>제목</h4>
			<input name="title" placeholder="Title" type="text" required>
		</div>
		<div>
			<h4>내용</h4>
			<textarea name="content" rows="6" placeholder="Content" style="resize:none" required></textarea>
		</div>
		<div>
			<h4>작성자</h4>
			<input name="writer" placeholder="Writer" type="text">
		</div>
		
		<button class="submit">등록</button>
		
		<a href="/board/list">취소</a>
		
	
	</form>

</body>
</html>