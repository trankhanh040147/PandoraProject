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
		<form action="<c:url value="/vendor/Transaction"/>" method="post">
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
						<h5 class="card-title" style="margin-left: 450px;">Lịch sử giao dịch của cửa hàng</h5>

						<table class="mb-0 table table-hover" style="width: 1060px">
							<thead>
								<tr>
									<th>STT</th>
									<th>Mã giao dịch</th>
									<th>Mã cửa hàng</th>
									<th>Mã người dùng</th>
									<th>Kiểu giao dịch</th>
									<th>Số tiền</th>
									<th>Ngày giao dịch</th>

								</tr>
							</thead>
							<c:forEach items="${TransactionList}" var ="x"> 
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>${x.id}</td>
									<td>${x.storeId}</td>
									<td>${x.userId}</td>
									<td> <c:if test="${x.isUp()==true }">Rút tiền</c:if>
									     <c:if test="${x.isUp()==false}">Nạp tiền</c:if>
									  
									</td>
									<td>${x.amount}</td>
									<td>${x.createdAt}</td>
								</tr>
							</tbody>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<c:url value="/vendor/Transaction?" var="listUrl" />
			
			<nav class="" aria-label="Page navigation example"style=" margin-left:500px">
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
</form>
			<!-- Body file -->
		</div>
	</div>