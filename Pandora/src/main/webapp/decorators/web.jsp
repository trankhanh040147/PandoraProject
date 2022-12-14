<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglib.jsp"%>

<c:set value="${pageContext.request.contextPath}/assets-web" var="dir"/>


<!DOCTYPE html>
<html lang="vi">

<head>

<title>About</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="${dir}/images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/customer/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${dir}/customer/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/customer/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/customer/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/customer/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${dir}/customer/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${dir}/css/util.css">
<link rel="stylesheet" type="text/css" href="${dir}/css/main.css">
<!--===============================================================================================-->


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
	

	<!--  SCRIPT  -->
	
	<!--===============================================================================================-->
	<script src="${dir}/customer/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="${dir}/customer/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="${dir}/customer/bootstrap/js/popper.js"></script>
	<script src="${dir}/customer/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="${dir}/customer/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function() {
			$(this).select2({
				minimumResultsForSearch : 20,
				dropdownParent : $(this).next('.dropDownSelect2')
			});
		})
	</script>
	<!--===============================================================================================-->
	<script src="${dir}/customer/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<!--===============================================================================================-->
	<script src="${dir}/customer/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function() {
			$(this).css('position', 'relative');
			$(this).css('overflow', 'hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed : 1,
				scrollingThreshold : 1000,
				wheelPropagation : false,
			});

			$(window).on('resize', function() {
				ps.update();
			})
		});
	</script>
	<!--===============================================================================================-->
	<script src="${dir}/js/main.js"></script>
	
	<!--  SCRIPT  -->

</body>


</html>