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
					THÊM THUỘC TÍNH SẢN PHẨM
						<div class="page-title-subheading">Hãy điền thông tin thuộc tính ở đây </div>
					</div>
				</div>
			</div>
		</div>
		<div class="">
			<!-- Body file -->
			 <form action="<c:url value="/admin/style-value/add"/>" method="post" >
			 <div class="content">
            <div class="container-fluid">
                <div class="row justify-content-center">
               
                     <div class="col-lg-6 col-md-4" >
                        <div class="card">
                            <div class="header">
                                <h4 class="title" style="text-align: center;">Thông tin thuộc tính sản phẩm</h4>
                            </div>
                            <div class="content">
                               <!-- <div class="row"> -->

                                        <div class="col-md-11 form-group justify-content-center">
                                                <label>Tên thuộc tính</label>
                                                <input  class="form-control border-input"  name="name" value=""/>
                                        </div>
                                        <div class="col-md-11 form-group justify-content-center">
                                            <div class="form-group">
                                                <label>Mã loại thuộc tính</label>
                                                 <input class="form-control border-input" name="style_id" value=""/>
                                            </div>
                                        </div>
                                        <div class="col-md-11 form-group">
                                            <div class="form-group">
                                                <label>Ngày tạo</label>
                                                <% DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                                Date date = new Date(); %>
                                                <input  class="form-control border-input" readonly name="createdAt" value="<%= (new java.util.Date()).toLocaleString()%>"/>
                                            </div>
                                        </div>
                                     
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd" style="margin-bottom: 15px;">Thêm</button>
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

