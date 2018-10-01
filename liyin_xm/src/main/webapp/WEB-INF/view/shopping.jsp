<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/resources/inc/inc.jsp" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物_李引</title>
<style type="text/css">
	.se2{  
    opacity: 0;  
    width: 10px;
    float: right;
}  
</style>
<script type="text/javascript">

	function deleteGoodsMore(){
		var ids="";
		$("[name='c']:checked").map(function(){
			ids+=","+$(this).val();
		});
		ids=ids.substring(1);
		if(ids==""||ids.lenth==0){
			alert("请至少选择一个商品!")
			return;
		}
		deleteGoods(ids);
	}

	function deleteGoods(id){
		if(confirm("确认删除该商品吗?")){
			$.post(
					"deleteGoods",
					{"id":id},
					function(obj){
						if(obj){
							alert("删除成功!");
							location="list";
						}else{
							alert("删除失败!")
						}
					},
					"json"
				);
		}
	}
	function updateStatus(s,id){
		var a=s==0?"下架":"上架";
		$.post(
			"updateStatus",
			{"s":s,"id":id},
			function(obj){
				if(obj){
					alert(a+"成功!");
					location="";
				}else{
					alert(a+"失败!")
				}
			},
			"json"
		);
	}
	function clickfiletest(){
		$("#f_file").click();
	}
	function upload() { 
		   var formData = new FormData($("#poiUpload")[0]); 
		   $.ajax({ 
		     url: 'upLoad', 
		     type: 'POST', 
		     data: formData, 
		     async: false, 
		     cache: false, 
		     contentType: false, 
		     processData: false, 
		     success: function(obj) {
		    	 if(obj){
						alert("商品信息上传成功,请手动添加商品效果图！");
						location="list";
					}else{
						alert("商品信息上传失败");
					}
		     }, 
		     error: function(data) {   
		     } 
		   }); 
	}
	function cartAdd(id){
		$.post(
				"cartAdd",
				{"id":id},
				function(obj){
					if(obj){
						ShowTip("加入购物车成功!","信息");
					}else{
						alert("商品信息上传失败");
					}
				},
				"json"
			);
	}
	function ShowTip(tip, type) {
	    var $tip = $('#tip');
	    if ($tip.length == 0) {
	        $tip = $('<strong id="tip" style="color: red;position:absolute;top:100px;left: 50%;z-index:9999"></strong>');
	        $('body').append($tip);
	    }
	    $tip.stop(true).prop('class', 'alert alert-' + type).text(tip).css('margin-left', -$tip.outerWidth() / 2).fadeIn(500).delay(1200).fadeOut(500);
	}
</script>
</head>
<body>
<h1 align="center">购物_李引技能测试</h1>
<hr width="60%">
	<table class="table table-bordered table-hover">
		<tr>
			<th colspan="8" >
			<div align="center">
				<form action="list" method="post">
					模糊查询:<input name="mohu" value="${mohu }">
					<input type="submit" value="查询" class="btn btn-success">
				</form>
			</div>
			</th>
			<th>
				<input type="button" value="添加"  class="btn btn-primary" onclick="location='toAdd'">
				<input type="button" value="批量删除" class="btn btn-warning" onclick="deleteGoodsMore()">
				<input type="button" value="导出商品" class="btn" onclick="location='downLoad'">
            	<input class="se1 btn" type="button" value="导入商品" onclick="clickfiletest()">  
				<form id="poiUpload" class="se2" method='post' enctype="multipart/form-data">  
					<input class="se2 btn" id="f_file" type="file" name="file" onchange="upload()"/>  
				</form>  
			</th>
		</tr>
		<tr>
			<th>序号</th>
			<th>商品图</th>
			<th>商品名</th>
			<th>生产日期</th>
			<th>创建时间</th>
			<th>商品分类</th>
			<th>商品价格</th>
			<th>商品状态</th>
			<th></th>
		</tr>
		<c:forEach items="${pager.datas }" var="data" varStatus="i">
			<tr>
				<td><label><input type="checkbox" name="c"  value="${data.id }" id="${data.id }" name="id">${i.count }</label></td>
				<td><!-- thumbnail -->
					<img class="img-circle img-responsive" alt="图片仅供参考" src="${data.img_path }" width="100px" height="100px">
				</td>
				<td>${data.name }</td>
				<td>${data.madedate }</td>
				<td>${fn:substring(data.createdate, 0, 16)}</td>
				<td>${data.type }</td>
				<td><font color="red">¥${data.price }</font></td>
				<td>
					<c:if test="${data.status==1 }">
						<font color="black">已上架</font>
					</c:if>
					<c:if test="${data.status==0 }">
						<font color="red">下架中</font>
					</c:if>
				</td>
				<td>
					<input type="button" value="修改" class="btn btn-info" onclick="location='toUpdate?id=${data.id }'">
					<input type="button" value="查看" class="btn btn-primary" onclick="location='lookGoods?id=${data.id }'">
					<input type="button" value="删除" class="btn btn-warning" onclick="deleteGoods('${data.id }')">
					<c:if test="${data.status==1 }">
						<input type="button" value="下架" class="btn btn-danger" onclick="updateStatus(0,'${data.id }')">
					</c:if>
					<c:if test="${data.status==0 }">
						<input type="button" value="上架" class="btn btn-default" onclick="updateStatus(1,'${data.id }')">
					</c:if>
					<input type="button" value="加入购物车" class="btn btn-info" onclick="cartAdd('${data.id }')">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
			<div align="center">
				<jsp:include page="/resources/inc/pager.jsp">
                             <jsp:param value="list" name="url"/>
                             <jsp:param value="${pager.total }" name="items"/>
                             <jsp:param value="${mohu }" name="mohu"/>
                </jsp:include></div>
			</td>
			<td align="center">
				<input type="button" value="查看购物车" class="btn btn-info" onclick="location='toCart'">
			</td>
		</tr>
	</table>
</body>
</html>