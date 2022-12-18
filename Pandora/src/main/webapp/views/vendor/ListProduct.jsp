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
						<table class="mb-0 table table-hover" style="width: 1060px">
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
								<tr>
									<th scope="row">1</th>

									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>

									<td>
										<a href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
										class=" fa fa-upload"></a>
										<a href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
										class=" pe-7s-close-circle" style="margin: 5px;font-size: 20px;"></a> 
										</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<!-- Body file -->
		</div>
	</div>