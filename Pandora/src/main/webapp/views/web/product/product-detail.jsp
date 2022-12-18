<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

	<!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Chi tiết sản phẩm</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Sản phẩm</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Chi tiết sản phẩm</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Shop Detail Start -->
    <div class="container-fluid py-5">
    
    	<form action="${Url}cart/add-item" method="post">
        <div class="row px-xl-5">
            <div class="col-lg-5 pb-5">
                <div id="product-carousel" class="carousel slide" data-ride="carousel">
                
                	<!--  Danh sách hình ảnh của sản phẩm -->
                    <div class="carousel-inner border">
						<c:forEach items="${product.listImages}" var="img" varStatus="loop">
	                        <div class="carousel-item <c:if test="${loop.index==0}">active</c:if>">
	                            <img class="w-100 h-100" src="${ImgUrl}${img}" alt="Image">
	                        </div>
	                    </c:forEach>
                    </div>
                	<!--  Danh sách hình ảnh của sản phẩm -->
                	
                    <a class="carousel-control-prev" href="#product-carousel" data-slide="prev">
                        <i class="fa fa-2x fa-angle-left text-dark"></i>
                    </a>
                    <a class="carousel-control-next" href="#product-carousel" data-slide="next">
                        <i class="fa fa-2x fa-angle-right text-dark"></i>
                    </a>
                </div>
            </div>
			
	            <div class="col-lg-7 pb-5">
	                <h3 class="font-weight-semi-bold">${product.name}</h3>
	                <div class="d-flex mb-3">
	                    <div class="text-primary mr-2">
	                    <!-- Điểm đánh giá (Số lượng ngôi sao) -->
	                    <c:forEach begin="0" end="${product.rating - 1}" varStatus="loop">
	                        <small class="fas fa-star"></small>
	                    </c:forEach>
						<c:forEach begin="0" end="${5 - product.rating - 1}" varStatus="loop">
	                        <small class="far fa-star"></small>
	                    </c:forEach>
	                    
	                    <!-- Điểm đánh giá (Số lượng ngôi sao) -->
	                    </div>
	                </div>
	                <div class="d-flex">
		                <h3 class="font-weight-semi-bold mb-4">${UtilClass.Price(product.promotionalPrice)}đ</h3>
		                <h3 class="font-weight-semi-bold mb-4 text-muted ml-2"><del>${UtilClass.Price(product.price)}đ</del></h3>
	                </div>
	                <p class="mb-4"> ${product.description} </p>
	                <!-- Danh sách các style values -->
	                
	                <!-- Style1 -->
	                <c:if test="${style1.id != 0}">
		                <div class="d-flex mb-4">
		                    <p class="text-dark font-weight-medium mb-0 mr-3">${style1.name}:</p>
		                    <c:forEach items="${style1_list}" var="style1">
			                    <div class="custom-control custom-radio custom-control-inline">
			                            <input type="radio" class="custom-control-input" id="size-${style1.id}" name="style1" value="${style1.id}" required>
			                            <label class="custom-control-label" for="size-${style1.id}">${style1.name}</label>
								</div>
		                    </c:forEach>
		                </div>
	                </c:if>
	                <!-- Style1 -->
	                
	                 <!-- Style2 -->
	                <c:if test="${style1.id != 0}">
		                <div class="d-flex mb-4">
		                    <p class="text-dark font-weight-medium mb-0 mr-3">${style2.name}:</p>
		                    <c:forEach items="${style2_list}" var="style2">
			                    <div class="custom-control custom-radio custom-control-inline">
			                            <input type="radio" class="custom-control-input" id="size-${style2.id}" name="style2" value="${style2.id}" required>
			                            <label class="custom-control-label" for="size-${style2.id}">${style2.name}</label>
								</div>
		                    </c:forEach>
		                </div>
	                </c:if>
	                <!-- Style2 -->
	                
	                 <!-- Style3 -->
	                <c:if test="${style3.id != 0}">
		                <div class="d-flex mb-4">
		                    <p class="text-dark font-weight-medium mb-0 mr-3">${style3.name}:</p>
		                    <c:forEach items="${style3_list}" var="style3">
			                    <div class="custom-control custom-radio custom-control-inline">
			                            <input type="radio" class="custom-control-input" id="size-${style3.id}" name="style3" value="${style3.id}" required>
			                            <label class="custom-control-label" for="size-${style3.id}">${style3.name}</label>
								</div>
		                    </c:forEach>
		                </div>
	                </c:if>
	                 <!-- Style3 -->
	               
	                <!-- Danh sách các style values -->
	                <div class="d-flex align-items-center mb-4 pt-2">
	                    <div class="input-group quantity mr-3" style="width: 130px;">
	                        <div class="input-group-btn">
	                            <button type="button" class="btn btn-primary btn-minus" >
	                            <i class="fa fa-minus"></i>
	                            </button>
	                        </div>
	                        <input type="text" class="form-control bg-secondary text-center" name="quantity" value="1">
	                        <div class="input-group-btn">
	                            <button type="button" class="btn btn-primary btn-plus">
	                                <i class="fa fa-plus"></i>
	                            </button>
	                        </div>
	                    </div>
	                   	<!-- Gửi id của product về controller -->
	                    <input type="hidden" name="product_id" value="${product.id}"> 
	                    <button class="btn btn-primary px-3" type="submit"><i class="fa fa-shopping-cart mr-1"></i> Thêm giỏ hàng</button>
	                </div>
	                <div class="d-flex pt-2">
	                    <p class="text-dark font-weight-medium mb-0 mr-2">Share on:</p>
	                    <div class="d-inline-flex">
	                        <a class="text-dark px-2" href="https://vi-vn.facebook.com">
	                            <i class="fab fa-facebook-f"></i>
	                        </a>
	                        <a class="text-dark px-2" href="https://twitter.com/">
	                            <i class="fab fa-twitter"></i>
	                        </a>
	                        <a class="text-dark px-2" href="https://www.linkedin.com/">
	                            <i class="fab fa-linkedin-in"></i>
	                        </a>
	                        <a class="text-dark px-2" href="https://www.pinterest.com/">
	                            <i class="fab fa-pinterest"></i>
	                        </a>
	                    </div>
	                </div>
	            </div>
        </div>
        </form>
        
        
        <!-- Thông tin sản phẩm và đánh giá -->
        <div class="row px-xl-5">
            <div class="col">
                <div class="nav nav-tabs justify-content-center border-secondary mb-4">
                    <a class="nav-item nav-link active" data-toggle="tab" href="#tab-pane-1">Mô tả</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-2">Thông tin</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-3">Đánh giá (${product.rating})</a>
                </div>
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="tab-pane-1">
                        <h4 class="mb-3">Mô tả sản phẩm</h4>
                        <p>${product.description}</p>
                    </div>
                    <!-- <div class="tab-pane fade" id="tab-pane-2">
                        <h4 class="mb-3">Additional Information</h4>
                        <p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam sea. Consetetur vero aliquyam invidunt duo dolores et duo sit. Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod. Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut diam consetetur duo justo est, sit sanctus diam tempor aliquyam eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr sanctus eirmod takimata dolor ea invidunt.</p>
                        <div class="row">
                            <div class="col-md-6">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item px-0">
                                        Sit erat duo lorem duo ea consetetur, et eirmod takimata.
                                    </li>
                                    <li class="list-group-item px-0">
                                        Amet kasd gubergren sit sanctus et lorem eos sadipscing at.
                                    </li>
                                    <li class="list-group-item px-0">
                                        Duo amet accusam eirmod nonumy stet et et stet eirmod.
                                    </li>
                                    <li class="list-group-item px-0">
                                        Takimata ea clita labore amet ipsum erat justo voluptua. Nonumy.
                                    </li>
                                  </ul> 
                            </div>
                            <div class="col-md-6">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item px-0">
                                        Sit erat duo lorem duo ea consetetur, et eirmod takimata.
                                    </li>
                                    <li class="list-group-item px-0">
                                        Amet kasd gubergren sit sanctus et lorem eos sadipscing at.
                                    </li>
                                    <li class="list-group-item px-0">
                                        Duo amet accusam eirmod nonumy stet et et stet eirmod.
                                    </li>
                                    <li class="list-group-item px-0">
                                        Takimata ea clita labore amet ipsum erat justo voluptua. Nonumy.
                                    </li>
                                  </ul> 
                            </div>
                        </div>
                    </div> -->
                    <div class="tab-pane fade" id="tab-pane-3">
                        <div class="row">
                            <div class="col-md-6">
                                <h4 class="mb-4">1 đánh giá cho <b>${product.name}</b></h4>
                                <div class="media mb-4">
                                    <img src="${dir}/img/user.jpg" alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
                                    <div class="media-body">
                                        <h6>Danh Kinh Sô Phia<small> - <i>17, tháng 09, 2022</i></small></h6>
                                        <div class="text-primary mb-2">
                                            <i class="fas fa-star"></i>
                                            <i class="fas fa-star"></i>
                                            <i class="fas fa-star"></i>
                                            <i class="fas fa-star-half-alt"></i>
                                            <i class="far fa-star"></i>
                                        </div>
                                        <p>Sản phẩm rất chất lượng, đúng với trên mô tả đã ghi, giá cả hợp lí vừa phải, ship hàng rất nhanh chóng.</p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-md-6">
                                <h4 class="mb-4">Đánh giá sản phẩm</h4>
                                <small>Địa chỉ email của bạn không bị công khai. Hãy nhập đầy đủ những thông tin có gắn *</small>
                                <div class="d-flex my-3">
                                    <p class="mb-0 mr-2">Đánh giá của bạn * :</p>
                                    <div class="text-primary">
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                </div>
                                <form>
                                    <div class="form-group">
                                        <label for="message"> Phản hồi *</label>
                                        <textarea id="message" cols="30" rows="5" class="form-control"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Tên của bạn *</label>
                                        <input type="text" class="form-control" id="name" disabled value="${account.lastname}${' '}${account.firstname}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email của bạn *</label>
                                        <input type="email" class="form-control" id="email" >
                                    </div>
                                    <div class="form-group mb-0">
                                        <input type="submit" value="Hãy nhập đánh giá" class="btn btn-primary px-3">
                                    </div>
                                </form>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Thông tin sản phẩm và đánh giá -->
        
    </div>
    <!-- Shop Detail End -->

