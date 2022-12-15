package vn.pandora.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.pandora.Model.User;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {"/home","/vendor/home","/admin/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
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
			Constant.setAlert(req, resp, "success","Chào mừng bạn đến với trang chủ Pandora!");
			req.getRequestDispatcher("/views/web/index.jsp").forward(req, resp);
		}

	}

}
