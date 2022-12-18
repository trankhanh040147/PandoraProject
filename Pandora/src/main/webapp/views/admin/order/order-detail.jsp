<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="app-main__outer">
<div class="app-main__inner">
		<div class="app-page-title">
			<div class="page-title-wrapper">
				<div class="page-title-heading">

				</div>
			</div>
		</div>
		<form action="<c:url value="${Url}admin/order/detail"/>" method="post">
		<div class="row">
			<!-- Body file -->			
			<div class="col-lg-12">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title" style="margin-left:500px;">Chi tiết  đơn hàng </h5>	
										 <div class="position-relative form-group"><label for="avatar" class="">Tên khách hàng:</label><span>${order.firstname} &nbsp ${order.lastname}</span></div>
						  <div class="position-relative form-group"><label for="avatar" class="">Mã đơn hàng :</label><span>${order.id}</span></div>						   
						    <div class="position-relative form-group"><label for="avatar" class="">Ngày tạo đơn:</label><span>${order.createdAt}</span></div>
						
						<table class="mb-0 table table-hover">
							<thead>
								<tr>
									<th>STT</th>
									<th>Tên sản phẩm </th>
									<th>Mã sản phẩm</th>
									<th>Style sản phẩm</th>
									<th>Số lượng</th>								
									<th>Giá sản phẩm</th>
								</tr>
							</thead>
							
							<c:forEach items="${listItem}" var="x">	
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>${x.nameProduct}</td>
									<td>${x.productId}</td>
									<td>
										<c:forEach items="${x.styleValueIds}" var="st" varStatus="loop">
											${service.getOne(st).name}<c:if test="${loop.index != x.styleValueIds.size()-1}">,</c:if>
										</c:forEach>
							</td>
									<td>${x.count}</td>
									<td>${x.priceProduct}</td>
								</tr>
							</tbody>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
							<div class="text-center">
								<button type="submit" style="margin-left: 500px;"
									class="btn btn-info btn-fill btn-wd">Quay về</button>
							</div>
							<div class="clearfix"></div>
							<!-- Body file -->
		</div>
		</form>
	</div>