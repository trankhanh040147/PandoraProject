package vn.pandora.Controller.Vendor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatController
 */
@WebServlet("/vendor/stat/order")
public class StatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		LoadStatData(req,resp);
		req.getRequestDispatcher("/views/vendor/order-stat.jsp").forward(req, resp);
	}
	
	private void LoadStatData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Tìm danh sách tất cả các đơn hàng
		
		//Lọc tất cả các loại đơn hàng
		
		//Đẩy dữ liệu lên view
		
	}


}
