<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />
</head>
<body>

			<div class="content">
				<div class="form">
					<form action="/board/modify" method="Post">
						
						<div class="fields">
							<div class="field">
								<h4>번호</h4>
								<input type="text" name="bno" value="${boardVO.bno}" readonly>
							</div>
							<div class="field">
								<h4>제목</h4>
								<input type="text" name="title" value="${boardVO.title}" >
							</div>
							<div class="field">
								<h4>내용</h4>
								<textarea name="content" rows="6" style="resize:none" >${boardVO.content}</textarea>
							</div>
							 
							<div class="field">
								<h4>작성자</h4>
								<input type="text" name="writer" value="${boardVO.writer}" readonly>
							</div>
							
						</div>
						
						
							<input type="submit" class="button" value="수정 완료"/>
						
					</form>
				</div>
			</div>

</body>

	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
</html>