<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="margin-top: 36px;">
			<div class="col-10 offset-1">
			    <!-- 查询 -->
				<form class="form-inline" id="queryForm">
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" id="name" name="name" value="${student.name }"
							placeholder="请输入姓名">
					</div>
					<input type="hidden" id="pageNum" name="pageNum" value="${pageInfo.pageNum }">
					<input type="hidden" id="orderBy" name="orderBy" value="${student.orderBy }">
					<button type="button" class="btn btn-primary mb-2" onclick="query();">查询</button>
				</form>
				 <!-- 列表 -->
				<table class="table">
					<thead>
						<tr>
							<th scope="col"><input type="checkbox" name="chkALL" id="chkALL"></th>
							<th scope="col">#</th>
							<th scope="col">姓名</th>
							<th scope="col">省</th>
							<th scope="col">市</th>
							<th scope="col">区</th>
							<th scope="col" onclick="order();">时间</th>
							<th scope="col">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfo.list }" var="item">
						<tr>
							<th scope="row"><input type="checkbox" value="${item.id }" name="chk_list"></th>
							<th scope="row">${item.id }</th>
							<td>${item.name }</td>
							<td>${item.provice_name }</td>
							<td>${item.city_name }</td>
							<td>${item.area_name }</td>
							<td><fmt:formatDate value="${item.create_time }" pattern="yyyy-MM-dd"/></td>
							<td><button type="submit" class="btn btn-primary mb-2" onclick="edit('${item.id}');">编辑</button></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				 <!-- 全局按钮、分页 -->
				<div class="row">
					<div class="col-3">
						<button type="button" class="btn btn-primary mb-2" onclick="add();">添加</button>
						<button type="button" class="btn btn-primary mb-2" onclick="delByIds();">删除</button>
					</div>
					${pageInfo }
					<div class="col-9">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test="${pageInfo.hasPreviousPage}">
									<li class="page-item"><a class="page-link" href="javascript:gotoPage('${pageInfo.pageNum-1 }')">Previous</a></li>
								</c:if>
								<c:forEach items="${pageInfo.navigatepageNums }" var="item">
									<c:if test="${item==pageInfo.pageNum}">
										<li class="page-item active"><a class="page-link" href="javascript:gotoPage('${item }');">${item }</a></li>
									</c:if>
									<c:if test="${item!=pageInfo.pageNum}">
										<li class="page-item"><a class="page-link" href="javascript:gotoPage('${item }');">${item }</a></li>
									</c:if>
								</c:forEach>
								<c:if test="${pageInfo.hasNextPage }">
									<li class="page-item"><a class="page-link" href="javascript:gotoPage('${pageInfo.pageNum+1 }')">Next</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
				
			</div>

		</div>

	</div>
	<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public/js/checkbox.js"></script>
	<script type="text/javascript">
	
		function add() {
			window.location.href="/update"
		}
		
		function edit(id) {
			window.location.href="/update?id="+id
		}
		
		function query(){
			$("#queryForm").submit();
		}
		
		function gotoPage(pageNum){
			$("#pageNum").val(pageNum);
			query();
		}
		
		function delByIds(){
			var ids = getCheckboxIds();
			console.log(ids);
			$.post("delByIds",{ids:ids},function(res){
				if(res){
					$("#pageNum").val(1);
					query();
				}
			})
		}
		
		function order(){
			var orderBy = $("#orderBy").val();
			if("asc"==orderBy){
				$("#orderBy").val("desc")
			}else if("desc"==orderBy){
				$("#orderBy").val("asc")
			}
			console.log($("#orderBy").val());
			query();
		}
	</script>
</body>
</html>