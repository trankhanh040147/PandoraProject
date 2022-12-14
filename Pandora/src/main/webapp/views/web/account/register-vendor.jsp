<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>
<%@ include file="/common/taglib.jsp" %>

	<head>
		<title>Đăng kí tài khoản</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/views/web/account/register-vendor.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
			integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Merriweather:300,400,400i|Noto+Sans:400,400i,700"
			rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600" rel="stylesheet">
	</head>

	<body>

		<form action="<c:url value="/register/vendor/submit"/>" method="get">
			<div class="Register">
				<div class="form">

					<h2>Đăng ký tài khoản (Người bán)</h2>

					<label style="margin-left: -270px;">Họ</label> 
					<input type="text" name="lastname" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">Tên</label> 
					<input type="text" name="firstname" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">Email</label> 
					<input type="text" name="email" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">Số điện thoại</label> 
					<input type="text" name="phone" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">CMND/CCCD</label> 
					<input type="text" name="id_card" style="text-align: center; width: 50%;"> 
					
					<br/>
					
					<label style="margin-left: -270px;">Địa chỉ</label> 
					<input type="text" name="address" style="text-align: center; width: 50%;"> 
					
					<br/>
					<br/>
					
					<label style="margin-left: -230px;">Nhập mật khẩu </label>
					<input type="password" style="width: 40%; text-align: center" name="password">

					<br/>

					<label style="margin-left: -210px;">Nhập lại mật khẩu </label>
					<input type="password_confirm" style="width: 40%; text-align: center;" name="password_confirm">

					<br/>
					
					<button type="submit" class="button-submit">Đăng ký</button>
					
					<br/>
				</div>
			</div>
		</form>
	</body>

	</html>