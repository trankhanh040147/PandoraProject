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
					CẬP NHẬT CHI TIẾT THUỘC TÍNH
						<div class="page-title-subheading">Bạn có thể cập nhật thông tin thuộc tính ở đây </div>
					</div>
				</div>
			</div>
		</div>
		<div class="">
			<!-- Body file -->
			 <form action="<c:url value="/admin/style-value/update"/>" method="post" >
			 <div class="content">
            <div class="container-fluid">
                <div class="row justify-content-center">
               
                     <div class="col-lg-6 col-md-4" >
                        <div class="card">
                            <div class="header">
                                <h4 class="title" style="text-align: center;">Cập nhật thông tin cửa hàng</h4>
                            </div>
                            <div class="content">
                               <!-- <div class="row"> -->

                                        <div class="col-md-11 form-group style" >
                                                <label>Mã thuộc tính</label>
                                                 <input class="form-control border-input" readonly name="style_value_id" value="${style_value.id}"/>
                                        </div>
                                        <div class="col-md-11 form-group justify-content-center">
                                                <label>Tên thuộc tính</label>
                                                <input  class="form-control border-input"  name="name" value="${style_value.name}"/>
                                        </div>
                                        <div class="col-md-11 form-group justify-content-center">
                                            <div class="form-group">
                                                <label>Mã loại thuộc tính</label>
                                                 <input class="form-control border-input" name="style_id" value="${style_value.styleId}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-11 form-group">
                                            <div class="form-group">
                                                <label>Ngày tạo</label>
                                                <input  class="form-control border-input" readonly name="createdAt" value="${style_value.createdAt}"/>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="bio">Ngày cập nhật</label>
                                                <input type="text" name="updatedAt"  readonly class="form-control border-input" value="${style_value.updatedAt}">
                                            </div>
                                        </div>
                 
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd" style="margin-bottom: 15px;">Cập nhật</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                       <!--  </div> -->
                    </div>
                 

                </div>
            </div>
        </div>
			</form>
			<!-- Body file -->
		</div>
	</div>

