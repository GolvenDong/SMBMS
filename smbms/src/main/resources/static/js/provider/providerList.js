// var viewPro = $(".viewPro");
//
// viewPro.on("click",function(){
// 	var obj=$(this);
// 	window.location.href=path+"/provider.do?method=view&providerId="+obj.attr("providerId");
// });
//
// var deletePro = $(".deletePro");
// //删除时也采用ajax,这样页面不用重新请求
// deletePro.on("click",function(){
// 	var obj = $(this);
// 	if(confirm("要删除【"+obj.attr("providerName")+"】供应商吗？")){
// 		$.ajax({
// 			type:"GET",
// 			url:path+"/provider.do",
// 			data:{method:"delete",providerId:obj.attr("providerId")},
// 			dataType:"json",
// 			success:function(data){
// 				if(data.msg=="OK"){
// 					alert("删除成功");
// 					obj.parents("tr").remove();
// 				}else if(data.msg=="EXCEPTION"){
// 					alert("未找到该供应商");
//
// 				}else{
// 					alert("该供应商下还有"+data.msg+"个订单，删除供应商"+obj.attr("providerName")+"失败");
// 				}
// 			},
// 			error:function(){
// 				alert("删除失败");
// 			}
// 		});
// 	}
// });
//
// var modifyPro =$(".modifyPro");
// modifyPro.on("click",function(){
// 	var obj = $(this);
// 	window.location.href=path+"/provider.do?method=modify&providerId="+obj.attr("providerId");
//
// });

UsersPage();

function UsersPage() {
    var pages = $("#pages").val();
    var pageNum = $("#pageNum").val();

    var pagination = new Pagination({
        wrap: $('.am-pagination'),//存放分页内容
        count: parseInt(pages),//总页数
        current: parseInt(pageNum),//当前页
        prevText: '上一页', // prev 按钮的文本内容
        nextText: '下一页', // next 按钮的文本内容
        callback: function (current) { // 每一个页数按钮的回调事件
            console.log(current)
            location.href="/providerList?pageNo="+current;
        }
    });
}