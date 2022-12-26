package vn.pandora.Controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.Model.Product;
import vn.pandora.Model.Store;
import vn.pandora.Service.Impl.CategoryServiceImpl;
import vn.pandora.Service.Impl.ProductServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;

/**
 * Servlet implementation class ProductsController
 */
@WebServlet(urlPatterns = { "/admin/product", "/admin/product/permit", "/admin/product/ban" })
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductServiceImpl productService = new ProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		response.setContentType("text/html; charset=UTF-8");
		if (url.endsWith("/product")) {
			List<Product> list = new ArrayList<Product>();
			list = productService.GetAll(0, 100);
			request.setAttribute("service2", new CategoryServiceImpl());
			request.setAttribute("service", new StyleValueServiceImpl());
			request.setAttribute("listProduct", list);
			request.getRequestDispatcher("/views/admin/Products.jsp").forward(request, response);
		}

		else if (url.endsWith("permit")) {
			permiProduct(request, response);
		} else if (url.endsWith("ban")) {
			banProduct(request, response);
		}
	}

	private void permiProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("pId"));
		Product product = new Product();
		product = productService.GetOne(id);
		productService.permit(product);
		resp.sendRedirect(req.getContextPath() + "/admin/product/home");
	}

	private void banProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("pId"));
		Product product = new Product();
		product = productService.GetOne(id);
		productService.revoke(product);
		resp.sendRedirect(req.getContextPath() + "/admin/product/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
