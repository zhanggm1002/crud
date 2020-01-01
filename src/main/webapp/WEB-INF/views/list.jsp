<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<form class="form-inline">
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="请输入姓名">
					</div>
					<button type="submit" class="btn btn-primary mb-2">查询</button>
				</form>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">姓名</th>
							<th scope="col">省</th>
							<th scope="col">市</th>
							<th scope="col">区</th>
							<th scope="col">时间</th>
							<th scope="col">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfo.list }" var="item">
						<tr>
							<th scope="row">${item.id }</th>
							<td>${item.name }</td>
							<td>${item.provice_id }</td>
							<td>${item.city_id }</td>
							<td>${item.area_id }</td>
							<td>${item.create_time }</td>
							<td><button type="submit" class="btn btn-primary mb-2" onclick="edit('${item.id}');">编辑</button></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row">
					<div class="col-3">
						<button type="submit" class="btn btn-primary mb-2" onclick="add();">添加</button>
						<button type="submit" class="btn btn-primary mb-2">删除</button>
					</div>
					<div class="col-9">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#">Previous</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>
				
			</div>

		</div>

	</div>
	<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
		function add() {
			window.location.href="/update"
		}
		
		function edit(id) {
			window.location.href="/update?id="+id
		}
	</script>
</body>
</html>