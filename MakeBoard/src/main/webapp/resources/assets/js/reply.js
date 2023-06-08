/**
 * 
 */
 
 console.log("this is");
 let replyService=(function(){
 
 
 	function add(reply,callback){
 		console.log("add..");
 		
 		$.ajax({
 			url: "/reply/add",
 			type: "post",
 			data: JSON.stringify(reply),
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}			
 			} 		
 		}); 	
 	}
 	
 	function getList(param,callback,error){
 		let bno= param.bno;
 		
 	
	 	$.getJSON("/reply/"+bno+".json",function(result){
	 		
	 	
	 		if(callback){
	 			callback(result);
	 		}
	 	}).fail(function(xhr,status,err){
	 		if(error){
	 			error(err);
	 		}
	 	
	 	});
	} 	
	
	function displayTime(timeValue){
		let today=new Date();
		let date=new Date(timeValue);
		let gap=today.getTime()-date.getTime();
		
		if(gap<1000*60*60*24){
			let hh=date.getHours();
			let mm=date.getMinutes();
			
			return [hh<10?"0"+hh:hh, mm<10?"0"+mm:mm].join(':');
		}
		else{
			let yy=date.getFullYear();
			let mm=date.getMonth()+1;
			let dd=date.getDate();
			
			return [yy,mm<10?"0"+mm:mm, dd<10?"0"+dd:dd].join('-');
		
		}
	
	}
	
	
	function modify(reply,callback){
		$.ajax({
			url:"/reply/"+reply.rno,
			type: "post",
			data: JSON.stringify(reply),
			contentType:"application/json; charset:utf-8",
			success: function(result){
				if(callback){
					callback(result);
				}
			}
		
		
		});	
	}
	
	function remove(rno,callback){
		$.ajax({
			url:"/reply/"+rno,
			type: "delete",
			success: function(result){
				if(callback){
					callback(result);
				}
			}
		});
	}
 	
 	
 	
 
 
 	return {add:add,getList: getList, displayTime: displayTime, modify:modify, remove:remove};
 
 
 })();