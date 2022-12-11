<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="vi">

<head>


	<!--  Fonts and icons     -->
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
	
	<!-- Themify Icon -->
	<link href="${pageContext.request.contextPath}/assets/css/themify-icons.css" rel="stylesheet">
	
	<!-- FontAwesome v5 -->
	<!-- Search icons here: https://fontawesome.com/v5/search?o=r&m=free -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

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

	<!--  Gắn header theo role -->
	<c:set value="${account.roleid}" var="role"/>
	
	<c:choose>
		<c:when test="${role == 1}">
			<jsp:include page="/common/web/header-cust.jsp"></jsp:include>
		</c:when>
		<c:when test="${role == 2}">
			<jsp:include page="/common/web/header-vend.jsp"></jsp:include>
		</c:when>
		<c:when test="${role == 3}">
			<jsp:include page="/common/web/header-admin.jsp"></jsp:include>
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
	<jsp:include page="/common/web/footer.jsp"></jsp:include>
	<!--=== End Footer v4 ===-->

</body>

<!--  JS-->
<!--   Core JS Files   -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.js" type="text/javascript"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="${pageContext.request.contextPath}/assets/js/demo.js"></script>


</html>