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

import vn.pandora.Model.Order;
import vn.pandora.Model.Product;
import vn.pandora.Model.User;
import vn.pandora.Service.Impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderController
 */
@WebServlet(urlPatterns = {"/vendor/listOrder","/vendor/updatenotprocessed","/vendor/updateprocessing","/vendor/updateshipped","/vendor/updatecancelled"})
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       OrderServiceImpl orderService= new OrderServiceImpl();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();
		
		 HttpSession session = req.getSession();
		User users = (User) session.getAttribute("account");
		
	
	
		LoadOrder(req, resp);
		
		List<Order> listOrdersNotProcessed= new ArrayList<Order>();
		listOrdersNotProcessed= orderService.GetByStatus("not processed",users.getId());
		req.setAttribute("listOrdersNotProcessed", listOrdersNotProcessed);
  
		List<Order> listOrdersProcessing= new ArrayList<Order>();
		listOrdersProcessing= orderService.GetByStatus("processing",users.getId());
		req.setAttribute("listOrdersProcessing", listOrdersProcessing);
		
		List<Order> listOrdersShipped= new ArrayList<Order>();
		listOrdersShipped= orderService.GetByStatus("shipped",users.getId());
		req.setAttribute("listOrdersShipped", listOrdersShipped);
		
		List<Order> listOrdersDelivered= new ArrayList<Order>();
		listOrdersDelivered= orderService.GetByStatus("delivered",users.getId());
		req.setAttribute("listOrdersDelivered", listOrdersDelivered);
		
		
		List<Order> listOrdersCancelled= new ArrayList<Order>();
		listOrdersCancelled= orderService.GetByStatus("cancelled",users.getId());
		req.setAttribute("listOrdersCancelled", listOrdersCancelled);
		
		
		if (url.contains("updatenotprocessed")) {
			int id= Integer.parseInt(req.getParameter("id"));
			orderService.UpdateStatus(id,"processing" );
			resp.sendRedirect(req.getContextPath()+"/vendor/listOrder");
			return;
		}
		
		if (url.contains("updateprocessing")) {
			int id= Integer.parseInt(req.getParameter("id"));
			orderService.UpdateStatus(id,"shipped" );
			resp.sendRedirect(req.getContextPath()+"/vendor/listOrder");
			return;
		}
		if (url.contains("updateshipped")) {
			int id= Integer.parseInt(req.getParameter("id"));
			orderService.UpdateStatus(id,"delivered" );
			resp.sendRedirect(req.getContextPath()+"/vendor/listOrder");
            return;
		}
		if (url.contains("updatecancelled")) {
			int id= Integer.parseInt(req.getParameter("id"));
				orderService.UpdateStatus(id,"cancelled" );
				resp.sendRedirect(req.getContextPath()+"/vendor/listOrder");
				return;
		}
		
		req.getRequestDispatcher("/views/vendor/ListOrder.jsp").forward(req, resp);
	}

	
	private void LoadOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set số item mỗi trang
				int ItemsPerPage = 5;

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
				List<Order> orderList = orderService.GetAllByOwnerId(users.getId() ,(index - 1) * ItemsPerPage, ItemsPerPage
						);

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
				List<Order> orderListAll = orderService.GetAllByOwnerId( users.getId(),0, 200);
				int totalItems = orderListAll.size();
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
				req.setAttribute("listOrders", orderList);
				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */
	}

}
