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
						DANH SÁCH ĐƠN HÀNG TẤT CẢ CỬA HÀNG
						<div class="page-title-subheading">Tất cả đơn hàng của các
							cửa hàng bạn sở hữu</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- Body file -->
			<div class="mb-3 card">
				<div class="card-header card-header-tab-animation">
					<ul class="nav nav-justified">
						<li class="nav-item"><a data-toggle="tab" href="#tab-eg115-0"
							class="active nav-link">Tất cả</a></li>
						<li class="nav-item"><a data-toggle="tab" href="#tab-eg115-1"
							class="nav-link">Chờ xác nhận</a></li>
						<li class="nav-item"><a data-toggle="tab" href="#tab-eg115-2"
							class="nav-link">Chờ lấy hàng</a></li>
						<li class="nav-item"><a data-toggle="tab" href="#tab-eg115-3"
							class="nav-link">Đang giao</a></li>
						<li class="nav-item"><a data-toggle="tab" href="#tab-eg115-4"
							class="nav-link">Đã giao </a></li>
						<li class="nav-item"><a data-toggle="tab" href="#tab-eg115-5"
							class="nav-link">Đã hủy</a></li>

					</ul>
				</div>
				<div class="card-body">
					<div class="tab-content">
						<div class="tab-pane active" id="tab-eg115-0" role="tabpanel">
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
										<h5 class="card-title" style="margin-left: 350px;">Danh
											sách đơn hàng</h5>
										<table class="mb-0 table table-hover" style="width:1060px">
											<thead>
												<tr>
													<th>STT</th>
													<th>Mã đơn hàng</th>
													<th>Mã cửa hàng</th>
													<th>Mã khách hàng</th>
													<th>Số điện thoại</th>
													<th>Thành tiền</th>
													<th>Mã vẫn chuyển</th>
													<th style="width:200px; text-align: center; ">Địa chỉ</th>
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
													<td></td>
													<td></td>
													<td></td>
													<td ></td>
													<td></td>
													<td><a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-eye"></a> <a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-upload"></a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tab-eg115-1" role="tabpanel">
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
										<h5 class="card-title" style="margin-left: 350px;">Đơn
											hàng chờ xác nhận</h5>
										<table class="mb-0 table table-hover" style="width:1060px">
											<thead>
												<tr>
													<th>STT</th>
													<th>Mã đơn hàng</th>
													<th>Mã cửa hàng</th>
													<th>Mã khách hàng</th>
													<th>Số điện thoại</th>
													<th>Thành tiền</th>
													<th>Mã vẫn chuyển</th>
													<th style="width:200px; text-align: center; ">Địa chỉ</th>
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
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-eye"></a> <a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-upload"></a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tab-eg115-2" role="tabpanel">
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
										<h5 class="card-title" style="margin-left: 350px;">Đơn
											hàng chờ lấy hàng</h5>
								<table class="mb-0 table table-hover" style="width:1060px">
											<thead>
												<tr>
													<th>STT</th>
													<th>Mã đơn hàng</th>
													<th>Mã cửa hàng</th>
													<th>Mã khách hàng</th>
													<th>Số điện thoại</th>
													<th>Thành tiền</th>
													<th>Mã vẫn chuyển</th>
													<th style="width:200px; text-align: center; ">Địa chỉ</th>
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
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-eye"></a> <a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-upload"></a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tab-eg115-3" role="tabpanel">
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
										<h5 class="card-title" style="margin-left: 350px;">Đơn
											hàng đang giao</h5>
										<table class="mb-0 table table-hover" style="width:1060px">
											<thead>
												<tr>
													<th>STT</th>
													<th>Mã đơn hàng</th>
													<th>Mã cửa hàng</th>
													<th>Mã khách hàng</th>
													<th>Số điện thoại</th>
													<th>Thành tiền</th>
													<th>Mã vẫn chuyển</th>
													<th style="width:200px; text-align: center; ">Địa chỉ</th>
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
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-eye"></a> <a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-upload"></a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tab-eg115-4" role="tabpanel">
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
										<h5 class="card-title" style="margin-left: 350px;">Đơn
											hàng đã giao</h5>
										<table class="mb-0 table table-hover" style="width:1060px">
											<thead>
												<tr>
													<th>STT</th>
													<th>Mã đơn hàng</th>
													<th>Mã cửa hàng</th>
													<th>Mã khách hàng</th>
													<th>Số điện thoại</th>
													<th>Thành tiền</th>
													<th>Mã vẫn chuyển</th>
													<th style="width:200px; text-align: center; ">Địa chỉ</th>
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
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-eye"></a> <a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-upload"></a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tab-eg115-5" role="tabpanel">
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
										<h5 class="card-title" style="margin-left: 350px;">Đơn
											hàng đã hủy</h5>
										<table class="mb-0 table table-hover" style="width:1060px">
											<thead>
												<tr>
													<th>STT</th>
													<th>Mã đơn hàng</th>
													<th>Mã cửa hàng</th>
													<th>Mã khách hàng</th>
													<th>Số điện thoại</th>
													<th>Thành tiền</th>
													<th>Mã vẫn chuyển</th>
													<th style="width:200px; text-align: center; ">Địa chỉ</th>
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
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-eye"></a> <a
														href="${pageContext.request.contextPath}/vendor/informationStore?sid=1"
														class=" fa fa-upload"></a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>


			<!-- Body file -->
		</div>
	</div>