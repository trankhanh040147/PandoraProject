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
	<form action="<c:url value="/admin/store"/>" method="post">
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
									<th>Quyền hoạt động</th>
									<th>Id cửa hàng bán</th>
									<th>Cấp quyền</th>
									
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
									<td>
										<c:if test="${x.isSelling()}">✔</c:if>
										<c:if test="${!x.isSelling()}">❌</c:if>
									</td>
									<td>
										<c:if test="${x.isActive()}">✔</c:if>
										<c:if test="${!x.isActive()}">❌</c:if>
									</td>
									<td>${x.storeId }</td>

									<td><a
										href="${pageContext.request.contextPath}/admin/product/permit?pId=${x.getId()}"
										class=" fa fa-check"></a>
										<a
										href="${pageContext.request.contextPath}/admin/product/ban?pId=${x.getId()}"
										style="margin-left: 20px"
										class=" fa fa-times"></a>
										</td>
								</tr>
							</c:forEach>
							</tbody>
							
						</table>
					</div>
				</div>
			</div>
			

			
		</form>
			
			<!-- Body file -->
		</div>
	</div>