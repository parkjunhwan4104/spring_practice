/**
 * Javascript 모듈화
 * 
 * 함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
 * 화면 내에서 Javascript를 처리하다보면 이베트 처리 ,DOM, Ajax 처리 등
 * 복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript 코드를 여러 부품으로 분리하여 조립하는 형식으로 설계한다.
 */
 
 console.log("Reply Module...");
 let replyService=(function(){ 
 
 	//추가하기
 	
 	function add(reply,callback){
 		console.log("add reply......");
 		
 		$.ajax({  /*여러가지 설정이 필요할 때 ajax 사용*/
 			url: "/replies/new",
 			type: "post",
 			data: JSON.stringify(reply),
 			contentType:"application/json; charset=utf-8",
 			success: function(result){
 			 	if(callback){  /* 콜백함수를 제대로 전달 했다면*/
 			 		callback(result);
 			 	}
 			}
 		});
 	}
 	
 	// 목록보기
 	// param은 게시글 번호와 요청한 페이지를 받아올 수 있는 객체이다.
 	function getList(param,callback,error){
 		let bno= param.bno;
 		let page=param.page || 1; //let variable= a||b; --> a가 값이 없으면 b로 사용된다.
 		
 		//getJSON()은 빠르고 편하게 요청 후 JSON 데이터를 받아오기 위해 사용한다.
 		//.json을 붙인 이유는 XML이 default로 설정되어 있기 때문에 JSON 형식으로 전달받기 위해 사용한다.
 		$.getJSON("/replies/"+ bno +"/"+page+".json",function(list){ /* 전송방식은 get방식, 필요한 거 몇 개만 전달해도 정확하게 json을 받아올 수 있게끔 함*/
 			if(callback){
 				callback(list);
 			}
 		}).fail(function(xhr,status,err){
 			if(error){
 				error(err);
 			}
 		});
 	}
 	
 	
 	//댓글 삭제
 	function remove(rno,callback){
 		$.ajax({
 			url:"/replies/"+rno,
 			type: "delete",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		
 		
 		});
 	}
 	
 	//댓글 수정
 	function modify(reply,callback){
 		$.ajax({
 			url:"/replies/"+reply.rno,
 			type: "put",
 			data: JSON.stringify(reply),
 			contentType: "application/json; charset: utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 			
 		});
 	
 	}
 	
 	//댓글 1개 조회
 	function getReply(rno,callback){
 		$.getJSON("/replies/"+rno,function(reply){
 			if(callback){
 				callback(reply);
 			}
 		});
 	}
 
 	return {add: add, getList:getList, remove:remove, modify: modify, getReply: getReply}  /* {key, value}*/
 
 })();  
 /*선언하자마자 바로 사용하므로 메소드 이름이 필요가 없음 (일회성) */