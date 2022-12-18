<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Regular Tables - Tables are the backbone of almost all
	web applications.</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
<meta name="description"
	content="Tables are the backbone of almost all web applications.">
<meta name="msapplication-tap-highlight" content="no">

<!--
	    =========================================================
	    * ArchitectUI HTML Theme Dashboard - v1.0.0
	    =========================================================
	    * Product Page: https://dashboardpack.com
	    * Copyright 2019 DashboardPack (https://dashboardpack.com)
	    * Licensed under MIT (https://github.com/DashboardPack/architectui-html-theme-free/blob/master/LICENSE)
	    =========================================================
	    * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
	    -->

<link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet">

	<!--  Script  -->
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/main.js"></script>
	
	<!--  Script  -->

<!--=========================================================================================================================-->
	<!-- CSS và JS cho Notify alert -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	
	<link href="${pageContext.request.contextPath}/assets-web/css/themify-icons.css" rel="stylesheet">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets-web/css/alert.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/assets-web/css/animate.min.css">
	
	<script src="${pageContext.request.contextPath}/assets-web/js/demo.js"
		type="text/javascript">></script>
	<script
		src="${pageContext.request.contextPath}/assets-web/js/bootstrap-notify.js"></script>
	<!-- CSS và JS cho Notify alert -->
	
	<!--  Hiển thị alert -->
	<c:if test="${requestScope.alert!=null}">
		<script type="text/javascript">
				window.onload = function() {
					demo.showNtf(${requestScope.alertType}, "${requestScope.alert}", "${requestScope.alertIcon}");
				};
			</script>
	</c:if> 
	<!--  Hiển thị alert -->
	
	
	<!--  Hiển thị alert trên session-->
	<c:if test='${sessionScope.alert != null}'>
		<script type="text/javascript">
				window.onload = function() {
					demo.showNtf(${sessionScope.alertType}, "${sessionScope.alert}", "${sessionScope.alertIcon}");
				};
		</script>
		<c:remove var="alertType" scope="session" />
		<c:remove var="alert" scope="session" />
		<c:remove var="alertIcon" scope="session" />
		
	</c:if>  
	<!--  Hiển thị alert trên session-->
	<!--=========================================================================================================================-->

</head>

<body>

	<!--  Hiển thị alert nếu có -->
	<%-- <c:if test="${alert!=null}">
		<script type="text/javascript">
			window.onload = function() {
				demo.showNtf(${alertType}, "${alert}", "${alertIcon}");
			};
		</script>
	</c:if>  --%>
	<!--  Hiển thị alert nếu có -->
	
	<!--=== Header vendor ===-->
	<jsp:include page="/common/web/header-admin.jsp"></jsp:include>
	<!--=== Header vendor ===-->

	<!-- body -->
	<dec:body />
	<!-- body -->

	<!--=== Footer v4 ===-->
	<jsp:include page="/common/web/footer-vendor.jsp"></jsp:include>
	<!--=== End Footer v4 ===-->

</body>

</html>