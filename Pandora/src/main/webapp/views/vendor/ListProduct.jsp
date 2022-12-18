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
						Quản lý sản phẩm
						<div class="page-title-subheading">Xem danh sách sản phẩm và sửa xóa sản phẩm</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->

			<div class="col-lg-12">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title" style="margin-left: 450px;">Danh sách sản phẩm</h5>
						<table class="mb-0 table table-hover" >
							<thead>
								<tr>
									<th>STT</th>
									<th>Mã sản phẩm</th>
									<th>Tên sản phẩm</th>
									<th>Giá</th>
									<th>Số Lượng có sẵn</th>						
									<th>Phân loại</th>
									<th style="width:150px; text-align: center; ">Kiểu</th>
									<th>Trạng thái</th>
									<th>Id cửa hàng bán</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${listProduct}" var="x" varStatus="loop">
								<tr>
									<th style="color:blue;" >${loop.count}</th>

									<td >${x.id }</td>
									<td>${x.name }</td>
									<td>${x.promotionalPrice }</td>
									<td>${x.quantity }</td>
									<td>${service2.getOne(x.categoryId).name}</td>
									<td>	
									
									<c:forEach items="${x.styleValueIds}" var="st" varStatus="loop2">
											${service.getOne(st).name}<c:if test="${loop2.index != x.styleValueIds.size()-1}">,</c:if>
								</c:forEach>
									</td>
									<td>${x.isSelling() }</td>
									<td>${x.storeId }</td>

									<td>
										<a href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
										class=" fa fa-upload"></a>
										<a href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
										class=" pe-7s-close-circle" style="font-size: 20px;"></a> 
										</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
<%-- 			<c:set value="${pageContext.request.contextPath}/topic-list?topicType=${topicType}" var="listUrl"/>
 --%>			
 			<c:url value="/vendor/ListProduct?" var="listUrl" />
			
			<nav class="" aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item <c:if test="${index == '1'}">disabled</c:if>">
					<a href="${listUrl}index=1"
						class="page-link" aria-label="Previous"><span
							aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
					
					<c:forEach begin="${startPage}" end="${endPage}" var="i">
						<li class="page-item <c:if test="${index == i.toString()}">active</c:if>">
							<a class="page-link" href="${listUrl}index=${i}">${i}</a>
						</li>
					</c:forEach>
						
					<li class="page-item <c:if test="${index == lastPage}">disabled</c:if>"><a href="${listUrl}index=${lastPage}"
						class="page-link" aria-label="Next"><span aria-hidden="true">»</span><span
							class="sr-only">Next</span></a></li>
				</ul>
			</nav>
			
			
			
			<!-- Body file -->
		</div>
	</div>