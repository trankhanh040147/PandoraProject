<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

	<!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Giỏ hàng</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Trang chủ</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Giỏ hàng</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Cart Start -->
    <form method="post">
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Loại</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    
                    <!--  Load các CartItems -->
                    <c:forEach items="${cart_items_list}" var="item" varStatus="loop">
                        <tr>
                        	<input type="hidden" name="item${loop.index}" value="${item.id}"/>
                            <td class="align-middle"><img src="${ImgUrl}${item.product.listImages[0]}" alt="" style="width: 50px;"> 
                            <p>${item.product.name}</p>
                            </td>
                            <td class="align-middle">
                            <!-- Các style values-->
                            <c:forEach items="${item.styleValueIds}" var="st" varStatus="loop2">
											${style_service.getOne(st).name}<c:if test="${loop2.index != item.styleValueIds.size()-1}">,</c:if>
							</c:forEach>
                            <!-- Các style values-->
                            </td>
                            <td class="align-middle">${UtilClass.Price(item.product.promotionalPrice)}đ</td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary btn-minus" >
                                        <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control form-control-sm bg-secondary text-center" name="count${loop.index}" value="${item.count}">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary btn-plus">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle"><button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button></td>
                        </tr>
                    </c:forEach>
                    <!--  Load các CartItems -->
                    
                    </tbody>
                </table>
                <input type="hidden" name="total_items" value="${cart_items_list.size()}"/>
                <div class="input-group justify-content-center" style="margin-top:30px;">
                        <div class="input-group-append justify-content-center">
                            <button type="submit" class="btn btn-primary" onclick="form.action='${Url}cart/update-items'">Cập nhật giỏ hàng</button>
                        </div>
				</div>
            </div>
            <div class="col-lg-4">
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Thông tin giỏ hàng</h4>
                    </div>
                    <div class="card-body">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Tổng giá trị</h6>
                            <h6 class="font-weight-medium">${UtilClass.Price(totalCost)}</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Phí giao hàng</h6>
                            <h6 class="font-weight-medium">${UtilClass.Price(shipCost)}</h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Tổng tiền phải trả</h5>
                            <h5 class="font-weight-bold">${UtilClass.Price(payCost)}</h5>
                        </div>
                        <button type="submit" class="btn btn-block btn-primary my-3 py-3" onclick="form.action='${Url}checkout'"> Tiến hành thanh toán </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
    <!-- Cart End -->