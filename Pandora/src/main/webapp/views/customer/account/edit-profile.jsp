<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:set value="${pageContext.request.contextPath}/assets-web" var="dir"/>
<c:url value="/customer/account/profile" var="editProfileUrl"/>

	<!-- Page Header Start -->
	    <div class="container-fluid bg-secondary mb-5">
		<div
			class="d-flex flex-column align-items-center justify-content-center"
			style="min-height: 300px">
			<h1 class="font-weight-semi-bold text-uppercase mb-3">Thay đổi thông tin</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="">Tài khoản</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Thay đổi thông tin</p>
			</div>
		</div>
	</div>
    <!-- Page Header End -->

    <!-- Edit Profile Start -->
	<form method="post" action="${editProfileUrl}" enctype="multipart/form-data" >
    
	    <div class="container-fluid pt-5">
	        <div class="row px-xl-5">
	            <div class="col-lg-8">
	                <div id="success"></div>
			                <div class="mb-4">
			                    <h4 class="font-weight-semi-bold mb-4">Hồ sơ của tôi</h4>
			                    <div class="row">
			                        <div class="col-md-6 form-group">
			                            <label>Họ</label>
			                            <input name="lastname" value="${account.lastname}" class="form-control" type="text" placeholder="">
			                        </div>
			                        <div class="col-md-6 form-group">
			                            <label>Tên</label>
			                            <input name="firstname" value="${account.firstname}" class="form-control" type="text" placeholder="">
			                        </div>
			                        <div class="col-md-6 form-group">
			                            <label>E-mail</label>
			                            <input name="email" value="${account.email}" class="form-control" type="text" placeholder="">
			                        </div>
			                        <div class="col-md-6 form-group">
			                            <label>Số điện thoại</label>
			                            <input name="phone" value="${account.phone}" class="form-control" type="text" placeholder="">
			                        </div>
			                        <div class="col-md-12 form-group">
			                            <label>Địa chỉ</label>
			                            <input name="address" value="${account.address}"  class="form-control" type="text" placeholder=" ">
			                        </div>
			                        <div class="col-md-6 form-group">
			                            <label>CMND | CCCD</label>
			                            <input name="id_card" value="${account.id_card}" class="form-control" type="text" placeholder=" ">
			                        </div>
			                        <div class="col-md-6 form-group">
			                        	<br/> 
			                        </div>
			                        <div class="col-md-12 form-group">
			                        	<br/> 
			                            <button style="margin-left: 50%;" class="btn btn-primary py-2 px-4" type="submit" id="sendMessageButton">Cập nhật thông tin</button>
			                        </div>
			                    </div>
			                </div>
	               
	            </div>
	            
	            
	            <div class="col-lg-4">
	                <div class="card border-secondary mb-5">
	                    <div class="card-header bg-secondary border-0">
	                        <h4 class="font-weight-semi-bold m-0">Ảnh đại diện</h4>
	                    </div>
	                    <div class="card-body">
			                <div class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
			                   	<label> 
				                   	<input type="file" accept="image/*" name="avatar"
									onchange="document.querySelector('.profilepic__image').src = window.URL.createObjectURL(this.files[0]);
									document.querySelector('.avatar-topbar.border-white').src = window.URL.createObjectURL(this.files[0]);"
										style="display:none;cursor: pointer;">
									<a>
											<div class="profilepic" style="width: 150px; height: 150px;">
												<c:url value="/image?fname=${account.avatar}" var="imgUrl"></c:url>
												<img class="profilepic__image" src="${imgUrl}"
													onerror="this.src='${dir}/img/avatar/default-customer.png';this.onerror='';"
													width="150px" height="150px" alt="Profibild"
													style="align-items: center;">
												<div class="profilepic__content">
													<span class="profilepic__icon"><i
														class="fas fa-camera"></i></span> <span class="profilepic__text">Đổi
														ảnh</span>
												</div>
											</div>
									</a>
								</label>
				
			                    <hr>
			                    <h7 class="font-weight-semi-bold m-0" style="text-align: center;">Dụng lượng file tối đa 1 MB </h7>
			                    <br/>
			                    <h7 class="font-weight-semi-bold m-0" style="text-align: center;">Định dạng: .JPEG, .PNG</h7>
			                  
			                </div>
	                    </div>
	                 </div>
	            </div>
	            
	        </div>
	    </div>
	</form>
   
    <!-- Edit Profile End -->