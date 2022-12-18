<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglib.jsp"%>

<c:set value="${pageContext.request.contextPath}/assets-web" var="dir"/>

<!DOCTYPE html>
<html lang="vi">

<head>

	<meta charset="utf-8">
	<title>EShopper - Bootstrap Shop Template</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport">
	<meta content="Free HTML Templates" name="keywords">
	<meta content="Free HTML Templates" name="description">
		
	<!-- Favicon -->
	<link href="${dir}/img/favicon.ico" rel="icon">
	<!--===============================================================================================-->
	
	<!-- Google Web Fonts -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link
		href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
		rel="stylesheet">
	<!--===============================================================================================-->
	
	<!-- Font Awesome -->
	<link
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
		rel="stylesheet">
	<!--===============================================================================================-->
	<!-- Libraries Stylesheet -->
	<link href="${dir}/lib/owlcarousel/assets/owl.carousel.min.css"
		rel="stylesheet">
	<!--===============================================================================================-->
	<!-- Customized Bootstrap Stylesheet -->
	<link href="${dir}/css/style.css" rel="stylesheet">
	<!--===============================================================================================-->
	
	<!--===============================================================================================-->
	<!-- Customized Bootstrap Stylesheet -->
	<link href="${dir}/css/myCSS.css" rel="stylesheet">
	<!--===============================================================================================-->
	
	<!--===============================================================================================-->
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="${dir}/lib/easing/easing.min.js"></script>
	<script src="${dir}/lib/owlcarousel/owl.carousel.min.js"></script>
	
	<!-- Contact Javascript File -->
	<script src="${dir}/mail/jqBootstrapValidation.min.js"></script>
	<script src="${dir}/mail/contact.js"></script>
	
	<!-- Template Javascript -->
	<script src="${dir}/js/main.js"></script>
	<!--===============================================================================================-->
	
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

	<!--  Gắn header theo role -->
	<c:set value="${account.role}" var="role" />

	<c:choose>
		<c:when test="${role == 'customer'}">
			<jsp:include page="/common/web/header-customer.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="/common/web/header-guest.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	<!--  Gắn header theo role -->

	<!-- body -->
	<dec:body />
	<!-- body -->

	<!--=== Footer v4 ===-->
	<jsp:include page="/common/web/footer-web.jsp"></jsp:include>
	<!--=== End Footer v4 ===-->
</body>



</html>