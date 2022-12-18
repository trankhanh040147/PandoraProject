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
						THỐNG KÊ THU NHẬP THEO THỜI GIAN
						<div class="page-title-subheading">Thống kê thu nhập theo
							thời gian hàng ngày</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="app-header-left">
		<div class="search-wrapper">
			<div class="input-holder">
				<input type="date" name="search" class="search-input"
					placeholder="Chọn thời gian ">
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
			<div class="main-card mb-3 card"
				style="width: 1000px; margin-left: 70px">
				<div class="card-body">
					<h5 class="card-title"">Thống kê thu nhập theo thời gian</h5>
					<table class="mb-0 table table-hover">
						<thead>
							<tr>
								<th>STT</th>
								<th>Id cửa hàng</th>
								<th>Ngày</th>
								<th>Tổng thu nhập</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
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