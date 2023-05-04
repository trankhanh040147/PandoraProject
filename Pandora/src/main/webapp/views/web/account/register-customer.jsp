<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
<%@ include file="/common/taglib.jsp" %>
	<html>

	<head>
		<title>Đăng kí tài khoản</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/views/web/account/register-customer.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
			integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Merriweather:300,400,400i|Noto+Sans:400,400i,700"
			rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600" rel="stylesheet">
		
	<!-- Themify Icon -->
	<link href="${pageContext.request.contextPath}/assets-web/css/themify-icons.css" rel="stylesheet">
	
	<link href="${pageContext.request.contextPath}/assets-web/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets-web/css/animate.min.css" rel="stylesheet">

	<!--=========================================================================================================================-->
	<!-- CSS và JS cho Notify alert -->
	<link href="${pageContext.request.contextPath}/assets-web/css/themify-icons.css" rel="stylesheet">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets-web/css/alert.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets-web/css/animate.min.css">
	<script
		src="${pageContext.request.contextPath}/assets-web/js/jquery-1.10.2.js"
		type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath}/assets-web/js/demo.js"
		type="text/javascript">></script>
	<script
		src="${pageContext.request.contextPath}/assets-web/js/bootstrap-notify.js"></script>
	<!-- CSS và JS cho Notify alert -->
	
	<!--  Hiển thị alert -->
	<c:if test="${alert!=null}">
		<script type="text/javascript">
				window.onload = function() {
					demo.showNtf(${alertType}, "${alert}", "${alertIcon}");
				};
			</script>
	</c:if>
	<!--  Hiển thị alert -->
	<!--=========================================================================================================================-->

</head>


	<body>

	<!--  Hiển thị alert nếu có -->
	<c:if test="${alert!=null}">
		<script type="text/javascript">
			window.onload = function() {
				demo.showNtf(${alertType}, "${alert}", "${alertIcon}");
			};
		</script>
	</c:if>
	<!--  Hiển thị alert nếu có -->

	<form action="<c:url value="/register/customer/submit"/>" method="get">
			<div class="Register">
				<div class="form">

				<h2>Đăng ký tài khoản (Người mua)</h2>

					<label style="margin-left: -270px;">Họ</label> 
					<input type="text" name="lastname" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">Tên</label> 
					<input type="text" name="firstname" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">Email</label> 
					<input type="text" name="email_reg" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">Số điện thoại</label> 
					<input type="text" name="phone" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -230px;">Nhập mật khẩu </label>
					<input type="password" style="width: 40%; text-align: center" name="password_reg">

					<label style="margin-left: -210px;">Nhập lại mật khẩu </label>
					<input type="password" style="width: 40%; text-align: center;" name="password_confirm">

					<br/>
					
					<button type="submit" class="button-submit">Đăng ký</button>
					
					<br/>
					<br/>
					<br/>
					
				</div>
			</div>
		</form>
	</body>

</html>