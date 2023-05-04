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
						Quản lý tài khoản khách hàng
						<div class="page-title-subheading">Xem thông tin toàn bộ tài khoản khách hàng</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->

<div class="col-lg-12">
				<div class="main-card mb-3 card">
					<div class="card-body">
						<h5 class="card-title" style="margin-left: 450px;">Danh sách tài khoản </h5>
						<form action="admin/ManagerUser" method="post">
						<table class="mb-0 table table-hover" >
							<thead>
								<tr>
								<th>stt</th>
									<th>Tên khách hàng:</th>
									<th>Email</th>
									<th>Số điện thoại</th>
									<th>Mật khẩu</th>
									<th>Quyền</th>						
									<th>Địa chỉ</th>
									<th >Trạng thái Email</th>
									<th>Trạng thái Phone </th>
									
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${listUser}" var="x" varStatus="loop">
								<tr>
									
                                         <td>${loop.count}</td>
									<td >${x.firstname}&nbsp ${x.lastname}</td>
									<td>${x.email }</td>
									<td>${x.phone }</td>
									<td>${x.password }</td>
									<td>${x.role }</td>
									<td>${x.address}</td>
									<td>	
									<c:if test="${x.isEmailActive()}">✔</c:if>
									<c:if test="${!x.isEmailActive()}">❌</c:if>
									</td>								
									<td>	
									<c:if test="${x.isPhoneActive()}">✔</c:if>
									<c:if test="${!x.isPhoneActive()}">❌</c:if>
									</td>
															
								</tr>
							</c:forEach>
							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<!-- Body file -->
		</div>
	</div>