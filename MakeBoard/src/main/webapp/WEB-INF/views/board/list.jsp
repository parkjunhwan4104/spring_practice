<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
			<link rel="stylesheet" href="/resources/assets/css/main.css" />
			<style>
				body {transform: scale(0.8);}
				.small-width {display:none;}
				.big-width {display:block;}
				
				.table-wrapper {overflow-x :hidden;}
				
				select{
					width:15%;
					display:inline;
				}
				input[name='keyword']{
					display:inline;
					width:60%;
				}
				.search{
					width:20%;
				}
				
				
				@media(max-width: 918px){
					body {transform: scale(1); overflow-x:hidden;}
					.writer {display:none;}
					.regDate {display:none;}
					.updateDate {display:none;}
					.big-width { display:none;}
					.small-width{display:block;}
					select{
						width:100%;
						display:inline;
					}
					input[name='keyword']{
						display:inline;
						width:100%;
					}
					.search{
						width:100%;
					}
				}
			</style>
	</head>
	<body>
		<h3><a href="/board/add" class="button small">글 등록</a></h3>
		<div class="table-wrapper">
				<table>
					<thead>
						<tr class="tHead">
							<th class="bno">번호</th>
							<th class="title">제목</th>
							<th class="writer">작성자</th>
							<th class="regDate">작성일</th>
							<th class="updateDate">수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${boardList}">
							<tr class="tBody">
								<td class="bno">${board.bno}</td>
								<td class="title">${board.title}</a></td>
								<td class="writer">${board.writer}</td>
								<td class="regDate">${board.regDate}</td>
								<td class="updateDate">${board.updateDate}</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>

</body>
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>

</html>