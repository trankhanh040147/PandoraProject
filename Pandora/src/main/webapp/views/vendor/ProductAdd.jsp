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
						THÊM SẢN PHẨM MỚI
						<div class="page-title-subheading">Điền thông tin sản phẩm</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<!-- Body file -->
			
			<div class="col-md-6">
				<div class="main-card mb-3 card" style="width: 800px;margin-left:200px ">
					<div class="card-body" >
						<h5 class="card-title" style="margin-left:300px">Điền thông tin tạo sản phẩm</h5>
						<form enctype="multipart/form-data" action="${Url}vendor/addProduct" method="post">
							<div class="position-relative form-group">
								<label for="name" class="">Tên sản phẩm </label><input
									name="name" id="exampleEmail" placeholder="Nhập tên sản phẩm"
									type="text" class="form-control">
							</div>
							<div class="position-relative form-group">
								<label for="featured_image" class="">Ảnh đặc trưng</label><input
									name="featured_image" id="featured_image" type="file"
									class="form-control-file" name="featured_image"
									onchange="document.querySelector('.featured_image').src = window.URL.createObjectURL(this.files[0]);"
									accept="image/*" style="cursor: pointer;" /> 
									<img  class="featured_image" width="150" height="150"
									alt="Ảnh đặc trưng" style="align-items: center;" src="">
							</div>
							<div class="position-relative form-group">
								<label for="descripsion" class="">Mô tả </label><input
									name="descripsion" id="descripsion" placeholder="Nhập mô tả sản phẩm"
									type="text" class="form-control">
							</div>
								<div class="position-relative form-group">
								<label for="quantity" class="">Số lượng  </label><input
									name="quantity" id="quantity" placeholder="Nhập số lượng sản phẩm"
									type="text" class="form-control">
							</div>
								
								<div class="position-relative form-group">
								<label for="price" class="">Giá niêm yết </label><input
									name="price" id="price" placeholder="Nhập giá sản phẩm"
									type="text" class="form-control">
							</div>
							<div class="position-relative form-group">
								<label for="category" class="">Phân loại </label>
								<select id="cars" name="category">
									<c:forEach items="${listCategory}" var ="x">
								  <option value="${x.id}">${x.name}</option>
								</c:forEach>
								</select>
							</div>
                            <div class="position-relative form-group">
								<label for="Style-color" class="">Màu </label>
								<select id="cars" name="Style-color">
								<c:forEach items="${listStyleColor}" var ="y">
								  <option value="${y.id}">${y.name}</option>
								</c:forEach>
								</select>
							</div>
							 <div class="position-relative form-group">
								<label for="Style-size" class="">Kích cỡ </label>
								<select id="cars" name="Style-size">
									<c:forEach items="${listStylesize}" var ="z">
								  <option value="${z.id }">${z.name}</option>
								</c:forEach>
									
								</select>
							</div>
								 <div class="position-relative form-group">
								<label for="Style-size" class="">Loai:</label>
								<select id="cars" name="Style-type">
									<c:forEach items="${listStyletype}" var ="a">
								  <option value="${a.id }">${a.name}</option>
								</c:forEach>
									
								</select>
							</div>
							 <div class="position-relative form-group">
								<label for="storeId" class="">Cửa  hàng bán sản phẩm :</label>
								<select id="cars" name="storeId">
									<c:forEach items="${listStoreId}" var="a">
									<option value="${a.id}" >${a.name}</option>
									</c:forEach>
									
									
								</select>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-info btn-fill btn-wd">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<!-- Body file -->
		</div>
	</div>