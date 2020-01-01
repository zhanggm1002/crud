<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
				<form>
					<div class="form-group">
						<input
							type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
					</div>
					<div class="form-group">
					    <label for="exampleFormControlFile1">头像</label>
					    <input type="file" class="form-control-file" id="exampleFormControlFile1">
					 </div>
					<div class="form-group">
						<select	class="form-control" id="provice_id" name="provice_id" onchange="changeCity();">
							<option>请选择省</option>
							<c:forEach items="${proviceList}" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<select	class="form-control"  id="city_id" name="city_id">
							<option>请选择市</option>
							<c:forEach items="${cityList}" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<select	class="form-control"  id="area_id" name="area_id">
							<option>请选择区</option>
							<c:forEach items="${areaList}" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
					  <label class="form-check-label" for="defaultCheck1">
					    	读书
					  </label>
					</div>
					<div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
					  <label class="form-check-label" for="defaultCheck1">
					    	读书
					  </label>
					</div>
					<div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
					  <label class="form-check-label" for="defaultCheck1">
					    	读书
					  </label>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary mb-2">保存</button>
					</div>
				</form>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function add() {
			window.location.href = "/update"
		}

		function edit(id) {
			window.location.href = "/update?id=" + id
		}
		
		function changeCity() {
			$.get("/getAreaListByPid",{pid:$("#provice_id").val()},function(res){
				$("#city_id").html('<option>请选择市</option>');
				for ( var item in res) {
					var option = '<option value="'+res[item].id+'">'+res[item].name+'</option>';
					$("#city_id").append(option);
				}
			},"json")
		}
		
		
	</script>
</body>
</html>