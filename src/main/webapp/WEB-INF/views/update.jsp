<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				<form id="saveForm">
					<input type="hidden" id="id" name="id" value="${student.id }">
					<div class="form-group">
						<input
							type="text" class="form-control" id="name" name="name" value="${student.name }" placeholder="请输入姓名">
					</div>
					<div class="form-group">
					    <label for="exampleFormControlFile1">头像</label>
					    <input type="file" class="form-control-file" id="file" name="file">
					 </div>
					<div class="form-group">
						<select	class="form-control" id="provice_id" name="provice_id" onchange="changeCity();">
							<option value="">请选择省</option>
							<c:forEach items="${proviceList}" var="item">
								<c:if test="${item.id==student.provice_id }">
									<option value="${item.id }" selected >${item.name }</option>
								</c:if>
								<c:if test="${item.id!=student.provice_id }">
									<option value="${item.id }">${item.name }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<select	class="form-control"  id="city_id" name="city_id" onchange="changeArea();">
							<option value="">请选择市</option>
							<c:forEach items="${cityList}" var="item">
								<c:if test="${item.id==student.city_id }">
									<option value="${item.id }" selected >${item.name }</option>
								</c:if>
								<c:if test="${item.id!=student.city_id }">
									<option value="${item.id }">${item.name }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<select	class="form-control"  id="area_id" name="area_id">
							<option value="">请选择区</option>
							<c:forEach items="${areaList}" var="item">
								<c:if test="${item.id==student.area_id }">
									<option value="${item.id }" selected >${item.name }</option>
								</c:if>
								<c:if test="${item.id!=student.area_id }">
									<option value="${item.id }">${item.name }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<c:forEach items="${hobbyList }" var="item">
						<div class="form-check">
						  <input class="form-check-input" type="checkbox" value="${item.id }" <c:if test="${fn:contains(student.hobbyIds,item.id) }">checked="checked"</c:if> name="hobbyIds" >
						  <label class="form-check-label" for="defaultCheck1">
						    	${item.name }
						  </label>
						</div>
					</c:forEach>
					
					<div class="form-group">
						<button type="button" class="btn btn-primary mb-2" onclick="save();">保存</button>
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
			var proviceId = $("#provice_id").val();
			$.get("/getAreaListByPid",{pid:proviceId},function(res){
				$("#city_id").html('<option value="">请选择市</option>');
				for ( var item in res) {
					var option = '<option value="'+res[item].id+'">'+res[item].name+'</option>';
					$("#city_id").append(option);
				}
			},"json")
		}
		
		function changeArea() {
			var cityId = $("#city_id").val();
			$.get("/getAreaListByPid",{pid:cityId},function(res){
				$("#area_id").html('<option value="">请选择区</option>');
				for ( var item in res) {
					var option = '<option value="'+res[item].id+'">'+res[item].name+'</option>';
					$("#area_id").append(option);
				}
			},"json")
		}
		
		function save(){
			$("#saveForm").serialize();
			var formData = new FormData($("#saveForm")[0]);
			$.ajax({
				url:'/save',
				type:'post',
				data:formData,
				processData:false,
				contentType:false,
				success:function(res){
					console.log(res);
					location.href="/list"
				}
			});
		}
		
		
	</script>
</body>
</html>