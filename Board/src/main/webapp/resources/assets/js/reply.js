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
 	
 	
 	function getList(param,callback,error){
 		let bno= param.bno;
 		$.getJSON("/replies/"+ bno +".json",function(list){ /*get방식, 필요한 거 몇 개만 전달해도 정확하게 json을 받아올 수 있게끔 함*/
 			if(callback){
 				callback(list);
 			}
 		}).fail(function(xhr,status,err){
 			if(error){
 				error(err);
 			}
 		});
 	}
 
 	return {add: add, getList:getList}  /* {key, value}*/
 
 })();  
 /*선언하자마자 바로 사용하므로 메소드 이름이 필요가 없음 (일회성) */