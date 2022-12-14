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
						TẠO CỬA HÀNG MỚI
						<div class="page-title-subheading">Tạo ngay gian hàng của chính mình</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->
			
			<div class="col-md-6">
                                        <div class="main-card mb-3 card">
                                            <div class="card-body"><h5 class="card-title" style="margin-left:500px;">Điền thông tin tạo cửa hàng</h5>
                                                <form action="createStore" method="post">
                                                    <div class="position-relative form-group"><label for="name" class="">Tên cửa hàng </label><input name="name" id="exampleEmail" placeholder="Nhập tên cửa hàng" type="text" class="form-control"></div>
                                                    <div class="position-relative form-group"><label for="bio" class="">Mô tả cửa hàng</label><input name="bio" id="bio" placeholder="nhập mô tả cửa hàng" type="text"
                                                                                                                                                           class="form-control"></div>
                                                    <div class="position-relative form-group"><label for="avatar" class="">Ảnh đại diện</label><input name="avatar" id="avatar" type="file" class="form-control-file">                                                                    
                                                    </div>
                                                    <div class="position-relative form-group"><label for="cover" class="">Ảnh bìa </label><input name="cover" id="cover" type="file" class="form-control-file">                                                                    
                                                    </div>
                                                    <div class="position-relative form-group"><label for="featured_image" class="">Ảnh đặc trưng</label><input name="featured_image" id="featured_image" type="file" class="form-control-file">                                                                    
                                                    </div>
                                                    <button class="mt-1 btn btn-primary">Submit</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
			
			<!-- Body file -->
		</div>
	</div>