<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="app-main__outer">
	<div class="app-main__inner">
		<div class="app-page-title">
			<div class="page-title-wrapper">
				<div class="page-title-heading">
					<div class="page-title-icon">
						<i class="pe-7s-drawer icon-gradient bg-happy-itmeo"> </i>
					</div>

					<div>
						TÊN TRANG
						<div class="page-title-subheading">TIÊU ĐỀU TRANG</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->

			<nav class="" aria-label="Page navigation example">
				<ul class="pagination">
					<c:set
						value="${pageContext.request.contextPath}/topic-list?topicType=${topicType}"
						var="listUrl" />
						
					<li class="page-item <c:if test="${index == '1'}">disabled</c:if>">
					<a href="${listUrl}&index=1"
						class="page-link" aria-label="Previous"><span
							aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
							
					<c:forEach begin="${startPage}" end="${endPage}" var="i">
						
						<li class="page-item <c:if test="${index == i.toString()}">active</c:if>">
						<a href="${listUrl}&index=${i}"
						class="page-link">${i}</a></li>
						
					</c:forEach>
						
						
					<li class="page-item <c:if test="${index == lastPage}">disabled</c:if>">
					<a href="${listUrl}&index=${lastPage}"
						class="page-link" aria-label="Next"><span aria-hidden="true">»</span><span
							class="sr-only">Next</span></a></li>
							
				</ul>
				
			</nav>


			<!-- Body file -->
		</div>
	</div>