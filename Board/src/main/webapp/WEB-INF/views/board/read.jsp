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
									<div class="field"> <!-- 업로드될때의 화면(썸네일) -->
										<h4>첨부파일</h4>
										<div class="uploadResult">
											<ul></ul>
										</div>
									</div>
								</div>
								<ul class="actions special">
									<li>
										<input type="button" class="button" value="수정" onclick="location.href='/board/modify${criteria.params}&bno=${board.bno}'"/>
										<input type="submit" class="button" value="삭제"/>
									</li>
								</ul>
								<ul class="icons" style="margin:0;">
									<li>
										<span class="icon solid fa-envelope"></span>
										<strong>댓글</strong>
										
									</li>
									
													 -->
								</ul>
								<a class="button primary small register" style="display:block; margin-bottom: 30px;">댓글 등록</a>
								<div class="fields register-form" style="display:none;">
									<div class="field">
										<h4 class="reply-h4">작성자</h4>
										<input name="replier" placeholder="Replier" type="text"> 
									</div>
									<div class="field">
										<h4 class="reply-h4">댓글</h4>
										<textarea name="reply" rows="6" placeholder="Reply" style="resize:none;"></textarea>
									</div> 
									<div class="field registerButtons" style="text-align:right">
										<a href="javascript:void(0)" class="button primary small finish">등록</a>
										<a href="javascript:void(0)" class="button primary small cancel">취소</a>
									</div>
								</div>
								<ul class="replies"></ul>
								
							</form>
							<div class="paging" style="text-align:center">
							
							</div>
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
		
		function showReplyPage(total){
			let endNum= Math.ceil(page/10.0) *10;
			let startNum= endNum-9;
			let prev= startNum!=1;
			let next= false;
			let str="";
			
			
			if(endNum*10 >=total){
				endNum=Math.ceil(total/10.0);
			}
			
			if(endNum*10<total){
				next=true;
			}
			
			if(prev){
				str+=`<a class='changePage' href=`+(startNum-1)+`><code>&lt;</code></a>`;
			}
			
			for(let i=startNum;i<=endNum;i++){ //화면에 페이지 넘버 표시
				if(page==i){
					str+=`<code>`+i+`</code>`;
				}
				else{
					str+=`<a class='changePage' href=`+i+`><code>`+i+`</code></a>`;
				}
				
			}
			
			if(next){
				str+=`<a class='changePage' href=`+(endNum+1)+`><code>&gt;</code></a>`;
			}
			
			$("div.paging").html(str);
		}
		
		const repliesUL= $("ul.replies");
		
		function showList(page){
			replyService.getList({
				bno: bno,
				page: page
			},function(result){
				let list=result.list;
				let total=result.total;
				
				let str="";
				let date="";
				let check=false;
				
				for(let i=0; i<list.length; i++){
					check=list[i].replyDate==list[i].updateDate;
					date=check? list[i].replyDate: list[i].updateDate; //댓글을 등록할 경우엔 댓글등록시간이, 원래 댓글을 수정할 경우 수정한 시간이 나오도록 함
				
					//아래 생성한 것들이 DOM으로 추가한 태그들
					str+=`<li id=`+list[i].rno+` style="display: block; ">`;
					str+=`<div style="display:flex; justify-content:space-between" >`;
					str+=`<strong style="display:block;">`+list[i].replier +`</strong>`;
					str+=`<div>`;
					str+=`<a href=`+list[i].rno+` class="modify-ready">수정</a>`;
					str+=`<a href=`+list[i].rno+` class="modify-finish" style="display:none">수정완료</a>`;
					str+=`&nbsp;&nbsp;&nbsp;&nbsp;<a href=`+list[i].rno+` class="remove">삭제</a>`;
					str+=`</div>`;
					str+=`</div>`;
					str+=`<p class=`+list[i].rno+`>`+list[i].reply +`</p>`;
					str+=`<strong style="display:block; text-align: right">`+(check?"":"*")+replyService.displayTime(date)+`</strong>`;
					str+=`<div class="line"></div>`;
					str+=`</li>`;
							
				}
				
				repliesUL.html(str);
				showReplyPage(total);
				
			});
		}
		$("div.paging").on("click","a.changePage",function(e){
			e.preventDefault();
			page=$(this).attr("href");
			showList(page);
		});
		
		
		$("a.finish").on("click",function(e){
			e.preventDefault();
			replyService.add({
				bno: bno,
				reply:$("textarea[name='reply']").val(),
				replier: $("input[name='replier']").val()
				
			},function(){
				$("textarea[name='reply']").val("");
				$("input[name='replier']").val("");
				showList(page);
			});
		});
		
		
		$("a.register").on("click",function(e){
			e.preventDefault();
			$("div.register-form").show();
			$(this).hide();
		});
		
		$("a.cancel").on("click",function(e){
			e.preventDefault();
			$("div.register-form").hide();
			$("a.register").show();
		});
		
		//이벤트 위임
		//DOM으로 추가한 태그들은 이벤트가 발생하지 않는다.
		//이런 경우에는 기존에 있는 태그에 이벤트를 걸어주고,
		//새롭게 추가될 태그의 선택자를 ON("이벤트명","자식요소 선택자",callback)메소드에 같이 전달한다.
		//기존에 있었던 태그의 이벤트가 새롭게 추가된 자식요소에 위임된다.
		let check=false;  //하나 수정할때 다른 것들이 수정 안되도록 막는 변수
		
		$("ul.replies").on("click","a.modify-ready",function(e){  //ul.replies의 이벤트를 a.modify-ready로 위임
			e.preventDefault();
			
			
					
			if(check){
				alert("이미 수정중인 댓글이 있습니다.");
				return;
			}
			let finish=$("a.modify-finish");
			let rno=$(this).attr("href");
		//	console.log($("textarea."+rno).val());  //수정을 위해 입력한 것 까지 포함
		//	console.log($("textarea."+rno).text()); //이미 적혀있었던 것만 포함
			const p=$("li#"+rno).find("p."+rno); //li 태그중에 id를 rno로 갖고있는 애의 자식중 p인걸 찾기
				
			const remove=$("a.remove");
			
			
			$(this).hide();
			for(let i=0;i<finish.length;i++){
				if(finish[i].getAttribute("href")==rno){
					$(finish[i]).show();
					$(remove[i]).attr("class","modify-cancel");
					$(remove[i]).text("취소");
					
					break;
				}
			}
			
			p.html("<textarea class="+rno+" style='resize:none;'>"+p.text()+"</textarea>")
			check=true;
		});
		
		$("ul.replies").on("click","a.modify-finish",function(e){
			e.preventDefault();
			let rno=$(this).attr("href");
			const p=$("li#"+rno).find("p."+rno);
			
			
			replyService.modify({
				reply:$("textarea."+rno).val(),
				rno:$(this).attr("href")
			},function(){
				
				p.html($("textarea."+rno).val());
				
				$(this).hide();
				$(this).prev().show(); //현재 요소 바로 앞에 있는 요소를 보여주는거( 수정완료에서 수정으로 바꾸기 위해)
				showList(page);
				
				check=false;
			});
			
		});
		
		$("ul.replies").on("click","a.modify-cancel",function(e){
			
			e.preventDefault();
			
			let rno=$(this).attr("href");
			const p=$("li#"+rno).find("p."+rno);
			
			p.html($("textarea."+rno).text());
			
			$(this).attr("class","remove");
			$(this).text("삭제");
			
			$(this).prev().hide();
			$(this).prev().prev().show();
			check=false;
		});
		
		$("ul.replies").on("click","a.remove",function(e){
			e.preventDefault();
			
			if(confirm("정말 삭제하시겠습니까?")){
				replyService.remove($(this).attr("href"),function(){
					showList(page);	
				});	
			}
			
			
		});
		
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
		
		//첨부파일
		$(document).ready(function(e){
			var $uploadResult=$(".uploadResult ul");
				
			$.getJSON("files",{bno: "${board.bno}"},function(files){
				
				showUploadResult(files);
			});
			
			function showUploadResult(files){
				
				var str="";
				
				$(files).each(function(i,file){
					
					if(!file.fileType){  //일반파일
										
						str += "<li data-filename='" + file.fileName + "' data-uuid='" + file.uuid + "' data-uploadpath='" + file.uploadPath + "' data-filetype='" + file.fileType + "'>";
						str += "<div>";				
						str += "<img src='/resources/images/attach.png' width='100'>  <br>";						
						str += "</div>";
						str += "<span>"+file.fileName+"</span>";
						str += "</li>";
					}
					else{ //이미지 파일		
						var fileName=file.uploadPath+"/t_"+file.uuid+"_"+file.fileName
						
						str += "<li data-filename='" + file.fileName + "' data-uuid='" + file.uuid + "' data-uploadpath='" + file.uploadPath + "' data-filetype='" + file.fileType + "'>";
						str += "<div>";
						str += "<img src='/display?fileName="+fileName+"' width='100'> <br>";						
						str += "<span>"+file.fileName+"</span>";
						str += "</div>";
						str += "</li>";
						
					}
				});
				 $uploadResult.append(str);
				
			}
			
		});
		
	</script>
</html>