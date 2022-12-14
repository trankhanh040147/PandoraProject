package vn.pandora.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {"/vendor/home","/home","/admin/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString(); 

		// Trang chủ cho vendor
		if (url.contains("vendor")) {
			req.getRequestDispatcher("/views/vendor/index.jsp").forward(req, resp);
		}
		// Trang chủ cho admin
		else if (url.contains("admin")) {
			req.getRequestDispatcher("/views/admin/index.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/views/web/index.jsp").forward(req, resp);
		}

	}

}
