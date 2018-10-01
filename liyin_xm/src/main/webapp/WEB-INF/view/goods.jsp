<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/resources/inc/inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品-查看-修改-添加</title>
<script type="text/javascript">
	function getChild(element){
		get(element,"#two");
		$("#three").html("<option>---请选择---</option>");		
	}
	function getChild2(element){
		get(element,"#three");
	}
	function get(element,eid){
		$(eid).html("");
		var tid = $(element).val();
		$.post(
			"getChild",
			{"tid":tid},
			function(obj){
				var html ="<option>---请选择---</option>";
				for(var i in obj){
					html+="<option value='"+obj[i].tid+"'>"+obj[i].name+"</option>";
				}
				$(eid).html(html);
			},
			"json"
		);
	}
	
</script>
</head>
<body>
<h1 align="center">${title }</h1>${table }
<div id="t">
	<form action="${urlPath }" method="post" enctype="multipart/form-data">

		<table class="table table-bordered table-hover" id="t">
			<tr>
				<td>商品名:</td>
				<td>
					<input name="name" value="${goods.name }">
					<input type="hidden" value="${goods.id }" name="id">
				</td>
			</tr>
			<tr>
				<td>商品图:</td>
				<td>
				
					<img alt="图片仅供参考" src="${goods.img_path }" width="100px" height="100px">
					<input type="file" name="file"  class="btn btn-defult">
				</td>
			</tr>
			<tr>
				<td>生产日期:</td>
				<td>
					<input name="madedate" value="${goods.madedate }" onclick="WdatePicker()">
				</td>
			</tr>
			<tr>
				<td>赠品:</td>
				<td>
					<input name="gift" value="${goods.gift }">
				</td>
			</tr>
			<tr>
				<td>商品价格:</td>
				<td>
					<input name="price" value="${goods.price }">
				</td>
			</tr>
			<tr>
				<td>选择分类:</td>
				<td>
					一级:<select onchange="getChild(this)">
						<option>---请选择---</option>
						<c:forEach items="${types }" var="type">
							<option value="${type.tid }"
							<c:if test="${type.tid==goods.tid }">selected</c:if>
							>${type.name }</option>
						</c:forEach>
					</select>
					二级:<select id="two" onchange="getChild2(this)">
						<option>---请选择---</option>
						${type2 }
					</select>
					三级:<select id="three" name="tid">
						<option>---请选择---</option>
						${type3 }
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="保存" class="btn btn-info">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>