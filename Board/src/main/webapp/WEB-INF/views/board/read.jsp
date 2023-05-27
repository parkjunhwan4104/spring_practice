<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Board</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<style>
			body {transform: scale(0.8); margin-top: -50px;}
			div.line{border-bottom: 1px solid #ff8b77;}
		</style>
	</head>
	<body class="is-preload">
		<!-- Main -->
		<div id="main">
			<div class="wrapper">
				<div class="inner">

					<!-- Elements -->
					<header class="major">
						<h1>Board</h1>
						<p>게시글 상세보기</p>
					</header>
					<!-- Table -->
					<h3><a href="/board/list${criteria.params}" class="button small">목록 보기</a></h3>
					<div class="content">
						<div class="form">
							<form action="/board/remove">
								<div class="fields">
									<div class="field">
										<h4>번호</h4>
										<input type="text" name="bno" value="${board.bno}" readonly>
									</div>
									<div class="field">
										<h4>제목</h4>
										<input type="text" name="title" value="${board.title}" readonly>
									</div>
									<div class="field">
										<h4>내용</h4>
										<textarea name="content" rows="6" style="resize:none" readonly>${board.content}</textarea>
									</div>
									<div class="field">
										<h4>작성자</h4>
										<input type="text" name="writer" value="${board.writer}" readonly>
									</div>
								</div>
								<ul class="actions special">
									<li>
										<input type="button" class="button" value="수정" onclick="location.href='/board/modify${criteria.params}&bno=${board.bno}'"/>
										<input type="submit" class="button" value="삭제"/>
									</li>
								</ul>
								<ul class="icons">
									<li>
										<span class="icon solid fa-envelope"></span>
										<strong>댓글</strong>
										
									</li>
									
									<!-- 
									
									 -->
								</ul>
								<ul class="replies">
									
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</body>
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	<script src="/resources/assets/js/reply.js"></script>
	<script>
		let bno= "${board.bno}";	
		let page= 1;
		
		showList(page);
		
		const repliesUL= $("ul.replies");
		
		function showList(page){
			replyService.getList({
				bno: bno,
				page: page
			},function(list){
				let str="";
				let date="";
				let check=false;
				
				for(let i=0; i<list.length; i++){
					check=list[i].replyDate==list[i].updateDate;
					date=check? list[i].replyDate: list[i].updateDate; //댓글을 등록할 경우엔 댓글등록시간이, 원래 댓글을 수정할 경우 수정한 시간이 나오도록 함
														
					str+=`<li style="display: block;">`;
					str+=`<strong>`+list[i].replier +`</strong>`;
					str+=`<p>`+list[i].reply +`</p>`;
					str+=`<strong style="display:block; text-align: right">`+(check?"":"*")+replyService.displayTime(date)+`</strong>`;
					str+=`<div class="line"></div>`;
					str+=`</li>`;
							
				}
				
				repliesUL.html(str);
				
			});
		}
		
		/*
		replyService.add({
			bno: bno,
			reply: "모듈화 테스트",
			replier:"벤탕쿠르"
			
		},function(result){
			console.log(result);
		});
		*/
		
		
		/*
		replyService.getList({bno: bno, page:2},function(list){
			console.log(list);			
		});
		*/
		
		/*
		replyService.remove(101,function(result){
				alert(result);
		});
		
		*/
		
		/*
		replyService.modify({
			reply:"댓글 수정 테스트여",
			rno: 102
		},function(result){
			alert(result);
			
			
		});
		*/
		
		/*
		replyService.getReply(102,function(reply){
				console.log(reply);
		});
		*/
		
		
	</script>
</html>