package vn.pandora.Controller.Vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.pandora.Model.Order;
import vn.pandora.Model.OrderItem;
import vn.pandora.Service.Impl.OrderItemServiceImpl;
import vn.pandora.Service.Impl.OrderServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;

@WebServlet(urlPatterns = "/vendor/OrderDetail")
public class OrderDetailContrroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderItemServiceImpl orderService = new OrderItemServiceImpl();
	OrderServiceImpl orderService2 = new OrderServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		int id = Integer.parseInt(req.getParameter("oid"));
		Order order = orderService2.GetOneJoinUser(id);
		req.setAttribute("order", order);
		List<OrderItem> list = new ArrayList<OrderItem>();
		list = orderService.GetOne(id);

		req.setAttribute("listItem", list);
		req.setAttribute("service", new StyleValueServiceImpl());
		req.getRequestDispatcher("/views/vendor/OrderDetail.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect(req.getContextPath() + "/vendor/listOrder");

	}

}
