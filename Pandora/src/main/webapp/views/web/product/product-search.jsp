<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

	<!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Tìm kiếm sản phẩm</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Tìm kiếm</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Tìm kiếm sản phẩm</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Shop Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <!-- Shop Sidebar Start -->
            <div class="col-lg-3 col-md-12">
                <!-- Price Start -->
                <div class="border-bottom mb-4 pb-4">
                    <h5 class="font-weight-semi-bold mb-4">Lọc theo giá</h5>
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="price-all">
                            <label class="custom-control-label" for="price-all">Tất cả</label>
                            <span class="badge border font-weight-normal">39</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-1">
                            <label class="custom-control-label" for="price-1">50.000đ - 100.000đ</label>
                            <span class="badge border font-weight-normal">14</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-2">
                            <label class="custom-control-label" for="price-2">100.000đ - 200.000đ</label>
                            <span class="badge border font-weight-normal">11</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-3">
                            <label class="custom-control-label" for="price-3">200.000đ - 300.000đ</label>
                            <span class="badge border font-weight-normal">7</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="price-4">
                            <label class="custom-control-label" for="price-4">300.000đ - 400.000đ</label>
                            <span class="badge border font-weight-normal">5</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                            <input type="checkbox" class="custom-control-input" id="price-5">
                            <label class="custom-control-label" for="price-5">400.000đ - 500.000đ</label>
                            <span class="badge border font-weight-normal">4</span>
                        </div>
                    </form>
                </div>
                <!-- Price End -->
                
                <!-- Color Start -->
                <div class="border-bottom mb-4 pb-4">
                    <h5 class="font-weight-semi-bold mb-4">Lọc theo màu sắc</h5>
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="color-all">
                            <label class="custom-control-label" for="price-all">Tất cả</label>
                            <span class="badge border font-weight-normal">41</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-1">
                            <label class="custom-control-label" for="color-1">Đen</label>
                            <span class="badge border font-weight-normal">11</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-2">
                            <label class="custom-control-label" for="color-2">Trắng</label>
                            <span class="badge border font-weight-normal">12</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-3">
                            <label class="custom-control-label" for="color-3">Đỏ</label>
                            <span class="badge border font-weight-normal">8</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-4">
                            <label class="custom-control-label" for="color-4">Xanh dương</label>
                            <span class="badge border font-weight-normal">5</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                            <input type="checkbox" class="custom-control-input" id="color-5">
                            <label class="custom-control-label" for="color-5">Xanh lá</label>
                            <span class="badge border font-weight-normal">4</span>
                        </div>
                    </form>
                </div>
                <!-- Color End -->

                <!-- Size Start -->
                <div class="mb-5">
                    <h5 class="font-weight-semi-bold mb-4">Lọc theo kích cỡ</h5>
                    <form>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" checked id="size-all">
                            <label class="custom-control-label" for="size-all">Tất cả</label>
                            <span class="badge border font-weight-normal">46</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="size-1">
                            <label class="custom-control-label" for="size-1">XS</label>
                            <span class="badge border font-weight-normal">13</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="size-2">
                            <label class="custom-control-label" for="size-2">S</label>
                            <span class="badge border font-weight-normal">12</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="size-3">
                            <label class="custom-control-label" for="size-3">M</label>
                            <span class="badge border font-weight-normal">11</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="size-4">
                            <label class="custom-control-label" for="size-4">L</label>
                            <span class="badge border font-weight-normal">4</span>
                        </div>
                        <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                            <input type="checkbox" class="custom-control-input" id="size-5">
                            <label class="custom-control-label" for="size-5">XL</label>
                            <span class="badge border font-weight-normal">6</span>
                        </div>
                    </form>
                </div>
                <!-- Size End -->
            </div>
            <!-- Shop Sidebar End -->


            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-12">
                <div class="row pb-3">
                    <div class="col-12 pb-1">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <form action="">
                                <div class="input-group">
                                    <input type="text" id="keyword2" required class="form-control" placeholder="Tìm theo tên sản phẩm">
	                                    <div class="input-group-append" style="cursor: pointer;">
					                        <a onclick="this.href='${Url}search/product?keyword='+document.getElementById('keyword2').value">
						                        <span class="input-group-text bg-transparent text-primary" style="padding:0.65rem 0.75rem;">
						                            <i class="fa fa-search"></i>
						                        </span>
					                        </a>
		                  			    </div>
                                </div>
                            </form>
                            <div class="dropdown ml-4">
                                <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                        aria-expanded="false">
                                            Sắp xếp theo
                                        </button>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                    <a class="dropdown-item" href="#">Mới nhất</a>
                                    <a class="dropdown-item" href="#">Bán chạy</a>
                                    <a class="dropdown-item" href="#">Đánh giá </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <!-- Load danh sách các sản phẩm -->
                    <c:forEach items="${list_product}" var="product">
	                    <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
			                <div class="card product-item border-0 mb-4">
			                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
			                        <img class="img-fluid w-100" src="${ImgUrl}${product.listImages[0]}" alt="">
			                    </div>
			                    
			                    
				                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
				                        <h6 class="text-truncate mb-3">${product.name}</h6>
				                        <div class="d-flex justify-content-center">
				                            <h6>${UtilClass.Price(product.promotionalPrice)}đ</h6>
				                            <h6 class="text-muted ml-2"><del>${UtilClass.Price(product.price)}đ</del></h6>
				                        </div>
				                    </div>
			                    
			                    
			                    <div class="card-footer d-flex justify-content-between bg-light border">
			                        <a href="${Url}product/detail?product_id=${product.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>Xem chi tiết</a>
			                        <a href="${Url}product/detail?product_id=${product.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Thêm giỏ hàng</a>
			                    </div>
			                </div>
		           		 </div>
                    </c:forEach>
                    <!-- Load danh sách các sản phẩm -->
                    
                        <div class="col-12 pb-1">

                        <c:url value="/search/product?keyword=${cur_keyword}&" var="listUrl" />
                        <nav aria-label="Page navigation">
                          <ul class="pagination justify-content-center mb-3">
                            
                            <li class="page-item <c:if test="${index == '1'}">disabled</c:if>">
                              <a class="page-link" href="${listUrl}index=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                              </a>
                            </li>
                            
                            <c:forEach begin="${startPage}" end="${endPage}" var="i">
									<li class="page-item <c:if test="${index == i.toString()}">active</c:if>">
										<a class="page-link" href="${listUrl}index=${i}">${i}</a>
									</li>
							</c:forEach>
                           
                            <li class="page-item <c:if test='${index == lastPage}'>disabled</c:if>">
                              <a class="page-link" 
                              	href="${listUrl}index=${lastPage}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                              </a>
                            </li>
                            
                          </ul>
                        </nav>
                        
                        <%-- <nav aria-label="Page navigation">
                          <ul class="pagination justify-content-center mb-3">
								<li class="page-item <c:if test="${index == '1'}">disabled</c:if>">
								<a href="${listUrl}index=1"
									class="page-link" aria-label="Previous"><span
										aria-hidden="true">«</span><span class="sr-only">Previous</span></a></li>
								
								<c:forEach begin="${startPage}" end="${endPage}" var="i">
									<li class="page-item <c:if test="${index == i.toString()}">active</c:if>">
										<a class="page-link" href="${listUrl}index=${i}">${i}</a>
									</li>
								</c:forEach>
									
								<li class="page-item <c:if test="${index == lastPage}">disabled</c:if>"><a href="${listUrl}index=${lastPage}"
									class="page-link" aria-label="Next"><span aria-hidden="true">»</span><span
										class="sr-only">Next</span></a></li>
							</ul>
						</nav> --%>
                        
                    </div>
                </div>
            </div>
            <!-- Shop Product End -->
        </div>
    </div>
    <!-- Shop End -->