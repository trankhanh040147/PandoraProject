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
						DANH SÁCH CÁC CỬA HÀNG BẠN ĐÃ ĐĂNG KÍ
						<div class="page-title-subheading">Bạn có thể xem chi tiết thông tin từng cửa hàng cửa bạn tại đây</div>
					</div>
				</div>
			</div>
		</div>
		<div class="app-header-left">
			<div class="search-wrapper">
				<div class="input-holder">
					<input type="text" name="search" class="search-input"
						placeholder="Nhập mã của cửa hàng">
					<button class="search-icon">
						<span></span>
					</button>
				</div>
				<button class="close"></button>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->

			<div class="col-lg-6">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title" style="margin-left:500px;">Danh sách cửa hàng của bạn</h5>
						<table class="mb-0 table table-hover">
							<thead>
								<tr>
									<th>STT</th>
									<th>Tên cửa hàng</th>
									<th>Mô tả</th>
									<th>Trạng thái</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td></td>
									<td></td>
									<td></td>
									<td><a
										href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
										class=" fa fa-eye"></a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<!-- Body file -->
		</div>
	</div>