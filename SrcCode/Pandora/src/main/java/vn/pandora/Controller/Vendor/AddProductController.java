package vn.pandora.Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.pandora.Model.User;
import vn.pandora.Service.Impl.StoreServiceImpl;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet(urlPatterns = {"/vendor/addProduct"})
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StoreServiceImpl storeServiceImpl= new  StoreServiceImpl();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		User users = (User) session.getAttribute("account");
		
		List<Integer> list = storeServiceImpl.GetIdSrore(users.getId());
		req.setAttribute("idStore", list);
		
		req.getRequestDispatcher("/views/vendor/ProductAdd.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
