//跳转修改页面
$("#update").bind("click",function(){
	var userId = parseInt($("#userId").val());
	//confirm(userId);
	location.href="/user/updateAUser?id="+userId;
});

//删除
$("#del").bind("click",function(){
	if(confirm("确认删除？")){
		var userId = parseInt($("#userId").val());
		location.href="/user/deleteUser?id="+userId;
	}
});

//重置密码
$("#repassword").bind("click",function(){
	var userId=$("#userId").val();
	if(confirm("确认重置密码？")){
		
	}
});
