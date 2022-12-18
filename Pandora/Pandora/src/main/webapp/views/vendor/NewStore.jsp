<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<script language="javascript">
if ("${alert}"!=""){
	alert("${alert}");
}

</script>
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
						<div class="page-title-subheading">Tạo ngay gian hàng của
							chính mình</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Body file -->

			<div class="col-md-6">
				<div class="main-card mb-3 card"
					style="width: 800px; margin-left: 200px">
					<div class="card-body">
						<h5 class="card-title" style="margin-left: 300px">Điền thông
							tin tạo cửa hàng</h5>
						<form enctype="multipart/form-data" action="<c:url value="/vendor/createStore"/>" method="post">
							<div class="position-relative form-group">
								<label for="name" class="">Tên cửa hàng </label><input
									name="name" id="exampleEmail" placeholder="Nhập tên cửa hàng"
									type="text" class="form-control">
							</div>
							<div class="position-relative form-group">
								<label for="bio" class="">Mô tả cửa hàng</label><input
									name="bio" id="bio" placeholder="Nhập mô tả cửa hàng"
									type="text" class="form-control">
							</div>
							<div class="position-relative form-group">
								<label for="avatar" class="">Ảnh đại diện</label> <input
									name="avatar" id="avatar" type="file" class="form-control-file"
									onchange="document.querySelector('.avatarimg').src = window.URL.createObjectURL(this.files[0]);"
									accept="image/*" style="cursor: pointer;" /> <img
									class="avatarimg" width="150" height="150" alt="Ảnh đại diện"									
									style="align-items: center;"
									src="">
							</div>
							<div class="position-relative form-group">
								<label for="cover" class="">Ảnh bìa </label><input name="cover"
									id="cover" type="file" class="form-control-file" onchange="document.querySelector('.coverimg').src = window.URL.createObjectURL(this.files[0]);"
									accept="image/*" style="cursor: pointer;" /> <img
									class="coverimg" width="150" height="150" alt="Ảnh bìa"									
									style="align-items: center;"
									src="">
							</div>
							<div class="position-relative form-group">
								<label for="featured_image" class="">Ảnh đặc trưng</label><input
									name="featured_image" id="featured_image" type="file"
									class="form-control-file"onchange="document.querySelector('.featured_imagei').src = window.URL.createObjectURL(this.files[0]);"
									accept="image/*" style="cursor: pointer;" /> <img
									class="featured_imagei" width="150" height="150" alt="Ảnh đặc trưng"									
									style="align-items: center;"
									src="">
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