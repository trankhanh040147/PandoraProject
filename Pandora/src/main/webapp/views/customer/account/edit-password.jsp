<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:set value="${pageContext.request.contextPath}/assets-web" var="dir"/>
<c:url value="/customer/account/password" var="updPassUrl"/>

	<!-- Page Header Start -->
	    <div class="container-fluid bg-secondary mb-5">
		<div
			class="d-flex flex-column align-items-center justify-content-center"
			style="min-height: 300px">
			<h1 class="font-weight-semi-bold text-uppercase mb-3">Thay đổi mật khẩu</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="">Tài khoản</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Thay đổi mật khẩu</p>
			</div>
		</div>
	</div>
    <!-- Page Header End -->

    <!-- Password Form Start -->
    <div class="container-fluid pt-5">
       
        <div class="row px-xl-5" style="margin-left:33%;">
            <div class="col-lg-6 mb-5">
                <div class="contact-form">
                    <div id="success"></div>
                    
                    <form method="post" action="${updPassUrl}">
                        <div class="control-group">
                        	<label>Mật khẩu hiện tại</label>
                            <input type="password" class="form-control" name="current_password"
                                required="required" data-validation-required-message="Hãy nhập mật khẩu hiện tại!" />
                            <p class="help-block text-danger"></p>
                        </div>
                        <div class="control-group">
                        	<label>Mật khẩu mới</label>
                            <input type="password" class="form-control"  name="new_password"
                                required="required" data-validation-required-message="Hãy nhập mật khẩu mới!" />
                            <p class="help-block text-danger"></p>
                        </div>
                        <div class="control-group">
                        	<label>Xác nhận mật khẩu mới</label>
                            <input type="password" class="form-control"  name="confirm_password"
                                required="required" data-validation-required-message="Hãy nhập lại mật khẩu!" />
                            <p class="help-block text-danger"></p>
                        </div>
                        <div>
                            <button style="margin-left: 33%;" class="btn btn-primary py-2 px-4" type="submit" >Send
                                Message</button>
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- Password Form End -->