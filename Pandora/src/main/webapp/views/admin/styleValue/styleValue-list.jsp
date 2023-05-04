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
						DANH SÁCH CÁC THUỘC TÍNH
						<div class="page-title-subheading">Bạn có thể xem chi tiết thông tin từng thuộc tính sản phẩm tại đây</div>
					</div>
				</div>
			</div>
		</div>
		<form enctype="multipart/form-data" action="<c:url value="/vendor/listStore"/>" method="post">
		<div class="app-header-left">
			<div class="search-wrapper">
				<div class="input-holder">
					<input type="text" name="search" class="search-input"
						placeholder="Nhập mã của cửa hàng">
					<button type="submit" class="search-icon">
						<span></span>
					</button>
				</div>
				<button class="close"></button>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->

			<div class="col-lg-12">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title" ">Danh sách các thuộc tính sản phẩm</h5>
						<table class="mb-0 table table-hover">
							<thead>
								<tr style="text-align: center;">
									<th>STT</th>
									<th>Tên thuộc tính</th>
									<th>Loại thuộc tính</th>
									<th>Đã xoá</th>
									<th>Ngày tạo</th>
									<th>Ngày cập nhật</th>
									<!-- <th style="width: 40% ;text-align: center; ">Mô tả</th> -->
									<th></th>
								</tr>
							</thead>
							<c:forEach items="${styleValue_list}" var ="x" varStatus="loop">
							
							<tbody>
								<tr style="text-align: center;">
									<td style="color:blue;">${loop.count }</td>
									<td>${x.name}</td>
									<td>${x.style.name}</td>
									<td>
										<c:if test="${x.isDeleted()}">❌</c:if>
										<c:if test="${!x.isDeleted()}">✔</c:if>
									</td>
									<td>${x.createdAt}</td>
									<td>${x.updatedAt}</td>
									<td>
										<a href='<c:url value="/admin/style-value/update?id=${x.id}"/>'
										class=" fa fa-upload"></a>
										<a style="margin-left:5px;" href='<c:url value="/admin/style-value/delete?id=${x.id}"/>' 
										class=" fa fa-window-close"></a>
									</td>								
									</tr>
							</tbody>
							</c:forEach>
						</table>
					<div class="justify-content-center" style="margin-left: 45%; margin-top: 15px;">
						<a class="mb-2 mr-2 btn btn-success" href='<c:url value="/admin/style-value/add"/>'>Thêm thuộc tính</a>
					</div>
				</div>
			</div>

			<!-- Body file -->
		</div>
		</form>
	</div>