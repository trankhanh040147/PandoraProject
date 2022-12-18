package vn.pandora.Controller.Customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoController
 */
@WebServlet(urlPatterns = {"/customer/account/profile", "/customer/account/password"})
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString(); 
		
	    //Thay đổi thông tin profile
		if (url.contains("/customer/account/profile")) {
			req.getRequestDispatcher("/views/customer/account/edit-profile.jsp").forward(req, resp);
		}
	    //Thay đổi thông tin mật khẩu
	    else if (url.contains("/customer/account/password")) {
	    	req.getRequestDispatcher("/views/customer/account/edit-password.jsp").forward(req, resp);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
