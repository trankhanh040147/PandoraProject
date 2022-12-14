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
					THÔNG TIN CHI TIẾT CỬA HÀNG
						<div class="page-title-subheading">Bạn có thể cập nhật thông tin cửa hàng </div>
					</div>
				</div>
			</div>
		</div>
		<div class="">
			<!-- Body file -->
			 <form >
			 <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 col-md-5	">
                        <div class="card card-user">
                            <div class="image">
                                <img src="${pageContext.request.contextPath}/assets/img/avatars/2.jpg" alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                  <img class="avatar border-white" src="${pageContext.request.contextPath}/assets/img/avatars/2.jpg" alt="..."/>
                                  <h4 class="title" name ="name">Chet Faker </h4>
                                </div>
                                <p class="description text-center" name="bio">
                                    
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-md-4 col-md-offset-1">
                                        <h5>12<br /><small>Đánh giá</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5>2GB<br /><small>Doanh thu</small></h5>
                                    </div>
                                     <div class="col-md-4">
                                        <h5>2GB<br /><small>Ví điện tử </small></h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Cập nhật thông tin cửa hàng</h4>
                            </div>
                            <div class="content">
                               
        
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Mã cửa hàng</label>
                                                <span type="text" class="form-control border-input" name="storeId" ></span>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Mã chủ cửa hàng</label>
                                                <span type="text" class="form-control border-input" name="ownerId" ></span>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="bio">Mô tả cửa hàng</label>
                                                <input type="email" name="bio" class="form-control border-input" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Trạng thái</label>
                                                <input type="text" class="form-control border-input" name="isActive" value="">
                                            </div>
                                        </div>
                 
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Cập nhật</button>
                                    </div>
                                    <div class="clearfix"></div>
                                
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
			</form>
			<!-- Body file -->
		</div>
	</div>