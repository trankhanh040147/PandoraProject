<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:set value="${pageContext.request.contextPath}/assets-web" var="dir"/>

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

    <!-- Checkout Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8">
                <div class="mb-4">
                    <h4 class="font-weight-semi-bold mb-4">Hồ sơ của tôi</h4>
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>Tên</label>
                            <input class="form-control" type="text" placeholder="John">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Họ</label>
                            <input class="form-control" type="text" placeholder="Doe">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>E-mail</label>
                            <input class="form-control" type="text" placeholder="example@email.com">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Số điện thoại</label>
                            <input class="form-control" type="text" placeholder="+123 456 789">
                        </div>
                        <div class="col-md-12 form-group">
                            <label>Địa chỉ</label>
                            <input class="form-control" type="text" placeholder="123 Street">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>CMND | CCCD</label>
                            <input class="form-control" type="text" placeholder="123 Street">
                        </div>
                        
                    </div>
                </div>
                <div class="collapse mb-4" id="shipping-address">
                    <h4 class="font-weight-semi-bold mb-4">Shipping Address</h4>
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>First Name</label>
                            <input class="form-control" type="text" placeholder="John">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Last Name</label>
                            <input class="form-control" type="text" placeholder="Doe">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>E-mail</label>
                            <input class="form-control" type="text" placeholder="example@email.com">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Mobile No</label>
                            <input class="form-control" type="text" placeholder="+123 456 789">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address Line 1</label>
                            <input class="form-control" type="text" placeholder="123 Street">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address Line 2</label>
                            <input class="form-control" type="text" placeholder="123 Street">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Country</label>
                            <select class="custom-select">
                                <option selected>United States</option>
                                <option>Afghanistan</option>
                                <option>Albania</option>
                                <option>Algeria</option>
                            </select>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>City</label>
                            <input class="form-control" type="text" placeholder="New York">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>State</label>
                            <input class="form-control" type="text" placeholder="New York">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>ZIP Code</label>
                            <input class="form-control" type="text" placeholder="123">
                        </div>
                    </div>
                </div>
            </div>
            
<%--             <div class="col-lg-4 col-md-6 pb-1">
                <div class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                    <p class="text-right">15 Products</p>
                    <a href="" class="cat-img position-relative overflow-hidden mb-3">
                        <img class="img-fluid" src="${dir}/img/cat-1.jpg" alt="">
                    </a>
                    <h5 class="font-weight-semi-bold m-0">Men's dresses</h5>
                </div>
            </div> --%>
            
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
												onerror="this.src='${pageContext.request.contextPath}/assets/img/avatar/student.jpg';this.onerror='';"
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
			
		                    
		                    <h5 class="font-weight-semi-bold m-0">Dụng lượng file tối đa 1 MB | Định dạng: .JPEG, .PNG</h5>
		                </div>
                    </div>
                 </div>
            </div>
            
        </div>
    </div>
    <!-- Checkout End -->
    
    <!-- Avatar -->
							<label> <input type="file" accept="image/*" name="icon"
							onchange="document.querySelector('.profilepic__image').src = window.URL.createObjectURL(this.files[0]);
							document.querySelector('.avatar-topbar.border-white').src = window.URL.createObjectURL(this.files[0]);"
								style="cursor: pointer;">
							<a>
									<div class="profilepic">
										<c:url value="/image?fname=${account.avatar}" var="imgUrl"></c:url>
										<img class="profilepic__image" src="${imgUrl}"
											onerror="this.src='${pageContext.request.contextPath}/assets/img/avatar/student.jpg';this.onerror='';"
											width="100" height="100" alt="Profibild"
											style="align-items: center;">
										<div class="profilepic__content">
											<span class="profilepic__icon"><i
												class="fas fa-camera"></i></span> <span class="profilepic__text">Đổi
												ảnh</span>
										</div>
									</div>
							</a>
							</label>
							<!-- Avatar -->