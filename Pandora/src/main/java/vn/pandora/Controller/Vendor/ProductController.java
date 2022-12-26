package vn.pandora.Controller.Vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.pandora.Model.Product;
import vn.pandora.Model.User;
import vn.pandora.Service.Impl.CategoryServiceImpl;
import vn.pandora.Service.Impl.ProductServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(urlPatterns = { "/vendor/ListProduct", "/vendor/deletedProduct" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductServiceImpl procductService = new ProductServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();
		if (url.endsWith("ListProduct")) {
			LoadProduct(req, resp);
//		list = procductService.GetAll(0,100);
//		req.setAttribute("listProduct", list);
			req.setAttribute("service2", new CategoryServiceImpl());
			req.setAttribute("service", new StyleValueServiceImpl());
			req.getRequestDispatcher("/views/vendor/ListProduct.jsp").forward(req, resp);
		} else if (url.endsWith("deletedProduct")) {
			DeleteProduct(req, resp);
		}
	}

	private void LoadProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set số item mỗi trang
		int ItemsPerPage = 6;

		// Set tổng số trang hiển thị trên view
		int PagesDisplay = 9;

		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */
		// Lấy dữ liệu từ view
		String indexPage = req.getParameter("index");
		// Xử lứ trường hợp không truyền vào index
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */

		/* Phân trang */

		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */
		// Lấy dữ liệu theo số trang
		HttpSession session = req.getSession();
		User users = (User) session.getAttribute("account");
		List<Product> productList = procductService.GetAllByOwnerId((index - 1) * ItemsPerPage, ItemsPerPage,
				users.getId());

		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */

		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */
		// Đếm tổng số items

		// Cách 2: Lấy danh sách tất cả items và đếm số items
		List<Product> productListAll = procductService.GetAllByOwnerId(0, 200, users.getId());
		int totalItems = productListAll.size();
		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */

		// Tìm trang cuối cùng của toàn bộ danh sách items
		int lastPage = totalItems / ItemsPerPage + (totalItems % ItemsPerPage != 0 ? 1 : 0);

		// Xác định trang đầu (head) và trang cuối (tail)
		int head = index - PagesDisplay / 2;
		int tail = index + PagesDisplay / 2;
		head = head >= 1 ? head : 1;
		tail = tail <= lastPage ? tail : lastPage;
		head = tail - PagesDisplay + 1 >= 1 ? tail - PagesDisplay + 1 : head;
		tail = head + PagesDisplay - 1 <= lastPage ? head + PagesDisplay - 1 : tail;

		/* Phân trang */

		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */
		// Truyền dữ liệu lên view
		req.setAttribute("index", index);
		req.setAttribute("startPage", head);
		req.setAttribute("endPage", tail);
		req.setAttribute("lastPage", lastPage);

		// Dữ liệu xử lí
		req.setAttribute("listProduct", productList);
		/*
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		 */
	}

	private void DeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("pid"));
		procductService.UpdateIsActive(id);
		resp.sendRedirect(req.getContextPath() + "/vendor/ListProduct");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}