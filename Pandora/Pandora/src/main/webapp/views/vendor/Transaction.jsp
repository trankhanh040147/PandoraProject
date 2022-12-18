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
						Trang lịch sử giao dịch
						<div class="page-title-subheading">Hiện thị danh sách giao dịch của cửa hàng</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->
			<div class="app-header-left">
				<div class="search-wrapper">
					<div class="input-holder">
						<input type="text" name="search" class="search-input"
							placeholder="Nhập mã của đơn hàng">
						<button class="search-icon">
							<span></span>
						</button>
					</div>
					<button class="close"></button>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title" style="margin-left: 450px;">Lịch sử giao dịch</h5>

						<table class="mb-0 table table-hover" style="width: 1060px">
							<thead>
								<tr>
									<th>STT</th>
									<th>Id giao dịch</th>
									<th>Id cửa hàng</th>
									<th>Id người dùng</th>
									<th>Kiểu giao dịch</th>
									<th>Số tiền</th>
									<th>Ngày giao dịch</th>

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
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<!-- Body file -->
		</div>
	</div>