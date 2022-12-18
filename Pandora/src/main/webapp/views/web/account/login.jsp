<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    <html lang="en">
<%@ include file="/common/taglib.jsp" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập tài khoản </title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/web/account/login.css">
    
    <!--=========================================================================================================================-->
	<!-- CSS và JS cho Notify alert -->
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
    
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

    <section>
    
        <!--ảnh background-->
        <div class="img-bg">
            <img src="${pageContext.request.contextPath}/views/web/account/img/bg-login.png" alt="Hình Ảnh Minh Họa">
        </div>

        <div class="noi-dung">
            <div class="form" method="post">
                <h2>Trang Đăng Nhập</h2>
               
                <form action="<c:url value="/login"/>" method="post">

					<div class="input-form">
                        <span>Email</span>
                        <input type="text" placeholder="Nhập email vào đây" name="username">
                    </div>
                    <div class="input-form">
                        <span>Mật Khẩu</span>
                        <input type="password" placeholder="Nhập mật khẩu vào đây" name="password">
                    </div>
                    <div class="nho-dang-nhap">
                        <label><input type="checkbox" name="remember"> Nhớ Đăng Nhập</label>
                    </div>
                    <div class="input-form">
                        <input type="submit"  value="Đăng Nhập">
                    </div>
                    <div class="input-form">
                        <p>Bạn Chưa Có Tài Khoản Mua Sắm? <a href="${Url}register/customer">Đăng Ký (Mua) </a></p>
                        <p>Bạn Chưa Có Tài Khoản Bán Hàng? <a href="${Url}register/vendor">Đăng Ký (Bán) </a></p>
                    </div>
                    <div class="input-form">
                        <p>Quên mật khẩu <a href="${Url}forgot">Lấy lại mật khẩu</a></p>
                    </div>
                </form>
            </div>
        </div>
    </section>
</body>

</html>