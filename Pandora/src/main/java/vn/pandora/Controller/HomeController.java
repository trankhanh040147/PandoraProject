package vn.pandora.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.pandora.Model.Category;
import vn.pandora.Model.Product;
import vn.pandora.Model.User;
import vn.pandora.Service.iCategoryService;
import vn.pandora.Service.iProductService;
import vn.pandora.Service.Impl.CategoryServiceImpl;
import vn.pandora.Service.Impl.ProductServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {"/home","/vendor/home","/admin/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	iProductService productService = new ProductServiceImpl();
	iCategoryService categoryService = new CategoryServiceImpl();
	
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();
		
		HttpSession session = req.getSession();
		User account_cur = (User) session.getAttribute("account");
		
		// Trang chủ cho vendor
		if (url.contains("vendor")) {
			Constant.setAlert(req, resp, "success","Chào mừng bạn đến trang chủ,  " +account_cur.getLastname() + " " + account_cur.getFirstname()+ "!");
			req.getRequestDispatcher("/views/vendor/index.jsp").forward(req, resp);
		}
		// Trang chủ cho admin
		else if (url.contains("admin")) {
			req.getRequestDispatcher("/views/admin/index.jsp").forward(req, resp);
		} else {
			LoadCategories(req,resp);
			LoadTopProducts(req,resp);
			Constant.setAlert(req, resp, "success","Chào mừng bạn đến với trang chủ Pandora!");
			req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
		}

	}

	private void LoadCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Lấy top 6 category nổi bật
		List<Category> listCategories = new ArrayList<Category>();
		listCategories.add(categoryService.findById(2));
		listCategories.add(categoryService.findById(3));
		listCategories.add(categoryService.findById(4));
		listCategories.add(categoryService.findById(5));
		listCategories.add(categoryService.findById(6));
		listCategories.add(categoryService.findById(7));
		
		//Gắn dữ liệu lên view
		req.setAttribute("CatList", listCategories);
	}

	private void LoadTopProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Lấy top 8 product mới nhất
		List<Product> listProduct_TopNew = productService.findTop_Created(0,8);
		//Lấy top 8 product giảm giá nhiều nhất
		List<Product> listProduct_TopPromo = productService.findTop_Promo(0, 8);
		
		//Gắn dữ liệu lên view
		req.setAttribute("ListNew", listProduct_TopNew);
		req.setAttribute("ListPromo", listProduct_TopPromo);
		
	}
	
	

}
