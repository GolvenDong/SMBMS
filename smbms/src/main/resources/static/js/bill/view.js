//跳转修改页面
$("#update").bind("click",function(){
	var billId=$("#billId").val();
	window.location="billUpdate.html";
});
//删除
$("#del").bind("click",function(){
	var billId=$("#billId").val();
		if(confirm("确认删除？")){

		}
});
