<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<%@ include file="/common/taglib.jsp"%>

<head>
<meta charset="UTF-8">
</head>

<body>

	<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<div class="app-header header-shadow bg-premium-dark header-text-light">
			<div class="app-header__logo">
				<div class="logo-src"></div>
				<div class="header__pane ml-auto">
					<div>
						<button type="button"
							class="hamburger close-sidebar-btn hamburger--elastic"
							data-class="closed-sidebar">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>
			<div class="app-header__mobile-menu">
				<div>
					<button type="button"
						class="hamburger hamburger--elastic mobile-toggle-nav">
						<span class="hamburger-box"> <span class="hamburger-inner"></span>
						</span>
					</button>
				</div>
			</div>
			<div class="app-header__menu">
				<span>
					<button type="button"
						class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
						<span class="btn-icon-wrapper"> <i
							class="fa fa-ellipsis-v fa-w-6"></i>
						</span>
					</button>
				</span>
			</div>
			<div class="app-header__content">
				<div class="app-header-left">
					<div class="search-wrapper">
						<div class="input-holder">
							<input type="text" class="search-input"
								placeholder="Type to search">
							<button class="search-icon">
								<span></span>
							</button>
						</div>
						<button class="close"></button>
					</div>
					<ul class="header-menu nav">
						<li class="nav-item"><a href="${pageContext.request.contextPath}/vendor/home"
							class="nav-link"> <i class="nav-link-icon pe-7s-home">
							</i> Home
						</a></li>
						<li class="btn-group nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon fa fa-edit"></i>
								Projects
						</a></li>
						<li class="dropdown nav-item"><a href="javascript:void(0);"
							class="nav-link"> <i class="nav-link-icon fa fa-cog"></i>
								Settings
						</a></li>
					</ul>
				</div>
				<div class="app-header-right">
					<div class="header-btn-lg pr-0">
						<div class="widget-content p-0">
							<div class="widget-content-wrapper">
								<div class="widget-content-left">
									<div class="btn-group">
										<a data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false" class="p-0 btn"> <img width="42"
											class="rounded-circle" src="${pageContext.request.contextPath}/assets/images/avatars/1.jpg"
											alt=""> <i class="fa fa-angle-down ml-2 opacity-8"></i>
										</a>
										<div tabindex="-1" role="menu" aria-hidden="true"
											class="dropdown-menu dropdown-menu-right">
											<button type="button" tabindex="0" class="dropdown-item">User
												Account</button>
											<button type="button" tabindex="0" class="dropdown-item">Settings</button>
											<h6 tabindex="-1" class="dropdown-header">Header</h6>
											<button type="button" tabindex="0" class="dropdown-item">Actions</button>
											<div tabindex="-1" class="dropdown-divider"></div>
											<button type="button" tabindex="0" class="dropdown-item">Dividers</button>
										</div>
									</div>
								</div>
								<div class="widget-content-left  ml-3 header-user-info">
									<div class="widget-heading">Alina Mclourd</div>
									<div class="widget-subheading">VP People Manager</div>
								</div>

								<!-- Logout  -->
								<div class="widget-content-right header-user-info ml-3">
									<a type="button" href="${Url}logout"
										class="btn-shadow p-1 btn btn-danger btn-sm show-toastr-example">
										<i class="fa text-white fa-sign-out-alt pr-1 pl-1"></i>
									</a>
								</div>
								<!-- Logout  -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div>
		<div class="app-main">
			<div class="app-sidebar sidebar-shadow bg-vicious-stance sidebar-text-light">
				<div class="app-header__logo">
					<div class="logo-src"></div>
					<div class="header__pane ml-auto">
						<div>
							<button type="button"
								class="hamburger close-sidebar-btn hamburger--elastic"
								data-class="closed-sidebar">
								<span class="hamburger-box"> <span
									class="hamburger-inner"></span>
								</span>
							</button>
						</div>
					</div>
				</div>
				<div class="app-header__mobile-menu">
					<div>
						<button type="button"
							class="hamburger hamburger--elastic mobile-toggle-nav">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
				<div class="app-header__menu">
					<span>
						<button type="button"
							class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
							<span class="btn-icon-wrapper"> <i
								class="fa fa-ellipsis-v fa-w-6"></i>
							</span>
						</button>
					</span>
				</div>
				<div class="scrollbar-sidebar">
					<div class="app-sidebar__inner">
						<ul class="vertical-nav-menu">
							<li class="app-sidebar__heading">Quản lý cửa hàng</li>
							<li><a href="${pageContext.request.contextPath}/vendor/createStore"> <i
									class="metismenu-icon fa fa-plus-circle"></i> Tạo cửa hàng
							</a></li>
							<li><a href="${pageContext.request.contextPath}/vendor/listStore"> <i
									class="metismenu-icon fa fa-list-alt"></i>Danh sách cửa hàng sở hữu
							</a></li>
							
							
							
							<li class="app-sidebar__heading">Quản lý đơn hàng</li>
							<li><a href="${pageContext.request.contextPath}/vendor/listOrder"> <i
									class="metismenu-icon fa fa-list-alt"></i>Danh sách đơn hàng
							</a></li>
							
							<li class="app-sidebar__heading">Quản lý sản phẩm </li>
							<li><a href="${pageContext.request.contextPath}/vendor/ListProduct"> <i
									class="metismenu-icon fa fa-list-alt"> </i>Danh sách sản phẩm
							</a></li>
							<li><a href="${pageContext.request.contextPath}/vendor/addProduct"> <i
									class="metismenu-icon pe-7s-plus"> </i>Thêm sản phẩm
							</a></li>
							<li class="app-sidebar__heading">Quản lý ví điện tử </li>
							<li><a href="${pageContext.request.contextPath}/vendor/Transaction"> <i
									class="metismenu-icon fa fa-history"> </i>Lịch sử giao dịch 
							</a></li>
							<li><a href="${pageContext.request.contextPath}/vendor/Withdraw"> <i
									class="metismenu-icon pe-7s-cash"> </i>Rút tiền
							</a></li>
							<li class="app-sidebar__heading">Thống kê doanh thu</li>
							<li><a href="${pageContext.request.contextPath}/vendor/StatisticalByProduct"> <i
									class="metismenu-icon fa fa-database"> </i>Thống kê theo sản phẩm
							</a></li>
							<li><a href="${pageContext.request.contextPath}/vendor/StatisticalByOrder"> <i
									class="metismenu-icon fa fa-database"> </i>Thống kê theo đơn hàng 
							</a></li>
							<li><a href="${pageContext.request.contextPath}/vendor/StatisticalByDate"> <i
									class="metismenu-icon fa fa-database"> </i>Thống kê theo thời gian
							</a></li>
							
						</ul>
					</div>
				</div>
			</div>
</body>


</html>