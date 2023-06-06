<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<style>
			body {transform: scale(0.8); margin-top: -50px;}
			div.line{border-bottom: 1px solid #ff8b77;}
			h4.reply-h4{margin-bottom:0px;}
			
			.uploadResult{
				width:100%;
			}
			
			.uploadResult ul{
				display:flex;
				justify-content:center;
			}
			
			.uploadResult ul li{
				list-style:none;
			}
		</style>

</head>
<body>
		<h3><a href="/board/list?currentPageNum=${criteria.currentPageNum}&type=${criteria.type}&keyword=${criteria.keyword}" >목록 보기</a></h3>
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
				<br>
				
				<a href="/board/modify?bno=${boardVO.bno}&currentPageNum=${criteria.currentPageNum}&type=${criteria.type}&keyword=${criteria.keyword}">
					<button class="submit">수정</button>	
				</a>
				
				
				<a href="/board/delete?bno=${boardVO.bno}&currentPageNum=${criteria.currentPageNum}&type=${criteria.type}&keyword=${criteria.keyword}">
					<button class="submit">삭제</button>
				</a>
				
				<br>
				<br>
				<br>
				<br>
							
				<a class="button primary small register" style="display:block; margin-bottom: 30px;">댓글 등록</a>
				<div class="fields register-form" style="display:none;">
					<div class="field">
						<h4 class="reply-h4">작성자</h4>
						<input name="writer" placeholder="Writer" type="text"> 
					</div>
					<div class="field">
						<h4 class="reply-h4">댓글</h4>
						<textarea name="replyContent" rows="6" placeholder="ReplyContent" style="resize:none;"></textarea>
					</div> 
					<div class="field registerButtons" style="text-align:right">
						<a href="javascript:void(0)" class="button primary small finish">등록</a>
						<a href="javascript:void(0)" class="button primary small cancel">취소</a>
					</div>
				</div>
				<ul class="replies"></ul>
									
		 </div>		  						


</body>

	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	<script src="/resources/assets/js/reply.js"></script>
	<script > 
		const repliesUL=$("ul.replies");
		
		let bno="${boardVO.bno}";
		
		showList();
		
		function showList(){
			
			console.log("asdasda");
			replyService.getList({
				bno: bno
			
			},function(result){
							
				let str="";
				let date="";
				let timeCheck=false;
			
				for(let i=0;i<result.length; i++){
					timeCheck=result[i].regDate==result[i].updateDate;
					date=timeCheck? result[i].regDate: result[i].updateDate;
					
					str+=`<li id=`+result[i].rno+` style="display: block; ">`;
					str+=`<div style="display:flex; justify-content:space-between" >`;
					str+=`<strong style="display:block;">`+result[i].writer +`</strong>`;
					str+=`<div>`;
					str+=`<a href=`+result[i].rno+` class="modify-ready">수정</a>`;
					str+=`<a href=`+result[i].rno+` class="modify-finish" style="display:none">수정완료</a>`;
					str+=`&nbsp;&nbsp;&nbsp;&nbsp;<a href=`+result[i].rno+` class="remove">삭제</a>`;
					str+=`</div>`;
					str+=`</div>`;
					str+=`<p class=`+result[i].rno+`>`+result[i].replyContent +`</p>`;
					str+=`<strong style="display:block; text-align: right">`+(timeCheck?"":"*")+replyService.displayTime(date)+`</strong>`;
					str+=`<div class="line"></div>`;
					str+=`</li>`;
				}
				repliesUL.html(str);
			
			});	
		}
		
		
		$("a.finish").on("click",function(e){
			e.preventDefault();
			replyService.add({
				bno: bno,
				replyContent:$("textarea[name='replyContent']").val(),
				writer:$("input[name='writer']").val()
				
			},function(){
				$("textarea[name='replyContent']").val("");
				$("input[name='writer']").val("");
				showList();
			});
		});
		
		$("a.register").on("click",function(e){
			e.preventDefault();
			$("div.register-form").show();
			$(this).hide();
		})
		
		$("a.cancel").on("click",function(e){
			e.preventDefault();
			$("div.register-form").hide();
			$("a.register").show();
		})
	
	
	</script>
</html>