<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
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
								<td class="title"><a href="/board/detail/${board.bno}">${board.title}</a></td>
								<td class="writer">${board.writer}</td>
								<td class="regDate">${board.regDate}</td>
								<td class="updateDate">${board.updateDate}</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
				
				<div style="text-align: center;" class="big-width">
					<c:if test="${pageDTO.prev}">
						<a href="/board/list?currentPageNum=${pageDTO.startPage -1}"><code>&lt;</code></a>
					</c:if>
					<c:forEach var="num" begin="${pageDTO.startPage}" end="${pageDTO.endPage}"> <!-- jstl에서 1씩 증가 가능 but 1씩 감소는 불가능함 -->
						<c:choose>
							<c:when test="${pageDTO.criteria.currentPageNum ==num}">
								<code><c:out value="${num}"/></code>
							</c:when>
							<c:otherwise>
								<a href="/board/list?currentPageNum=${num}"><code><c:out value="${num}"/></code></a>
							</c:otherwise>
						</c:choose>
						
						
					</c:forEach>
					<c:if test="${pageDTO.next}">
						<a href="/board/list?currentPageNum=${pageDTO.endPage+1}"><code>&gt;</code></a>
					</c:if>
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