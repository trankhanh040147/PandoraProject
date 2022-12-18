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
		
		List<Order> listOrders= new ArrayList<Order>();
		listOrders= orderService.GetAllByOwnerId(users.getId());
		req.setAttribute("listOrders", listOrders);
		
		List<Order> listOrdersNotProcessed= new ArrayList<Order>();
		listOrdersNotProcessed= orderService.GetByStatus("not processed");
		req.setAttribute("listOrdersNotProcessed", listOrdersNotProcessed);
  
		List<Order> listOrdersProcessing= new ArrayList<Order>();
		listOrdersProcessing= orderService.GetByStatus("processing");
		req.setAttribute("listOrdersProcessing", listOrdersProcessing);
		
		List<Order> listOrdersShipped= new ArrayList<Order>();
		listOrdersShipped= orderService.GetByStatus("shipped");
		req.setAttribute("listOrdersShipped", listOrdersShipped);
		
		List<Order> listOrdersDelivered= new ArrayList<Order>();
		listOrdersDelivered= orderService.GetByStatus("delivered");
		req.setAttribute("listOrdersDelivered", listOrdersDelivered);
		
		
		List<Order> listOrdersCancelled= new ArrayList<Order>();
		listOrdersCancelled= orderService.GetByStatus("cancelled");
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
