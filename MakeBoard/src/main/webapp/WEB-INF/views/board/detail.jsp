<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>

</head>
<body>
		<h3><a href="/board/list" >목록 보기</a></h3>
		<div class="content">
				<div class="form">
						<div class="fields">
							<div class="field">
								<h4>번호</h4>
								<span type="text" >${boardVO.bno}</span>
							</div>
							<div class="field">
								<h4>제목</h4>
								<span type="text">${boardVO.title}</span>
							</div>
							<div class="field">
								<h4>내용</h4>
								<textarea name="content" rows="6" style="resize:none" readonly>${boardVO.content}</textarea>
							</div>
							<div class="field">
								<h4>작성자</h4>
								<span type="text">${boardVO.writer}</span>
							</div>
				   	   </div>
				</div>
				
				<button class="submit">
					<a href="/board/modify?bno=${boardVO.bno}">수정</a>
				</button>
				<button class="submit">
					<a href="/board/modify/${boardVO.bno}">삭제</a>
				</button>
					
				
		</div>		  						


</body>

	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
</html>