package vn.pandora.Controller.Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.pandora.Model.Cart;
import vn.pandora.Model.CartItem;
import vn.pandora.Model.User;
import vn.pandora.Service.iCartItemService;
import vn.pandora.Service.iCartService;
import vn.pandora.Service.iStyleValueService;
import vn.pandora.Service.Impl.CartItemServiceImpl;
import vn.pandora.Service.Impl.CartServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet(urlPatterns = { "/checkout", "/checkout/submit" })
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	iCartItemService cartItemService = new CartItemServiceImpl();
	iCartService cartService = new CartServiceImpl();
	iStyleValueService styleValueService = new StyleValueServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SubmitCheckout(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();

		// Trang chủ cho vendor
		if (url.endsWith("checkout")) {
			Checkout(req, resp);
		}
		// Trang chủ cho vendor
		else if (url.endsWith("submit")) {
			SubmitCheckout(req, resp);
		}
	}

	private void Checkout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy thông tin cart hiện tại từ session
		HttpSession session = req.getSession();
		Cart cart_cur = (Cart) session.getAttribute("cart");

		// Nếu chưa có cart thì thông báo lỗi
		if (cart_cur == null) {
			Constant.setAlertSession(req, resp, "error", "Giỏ hàng rỗng!");
			resp.sendRedirect(req.getContextPath() + "/cart");
			return;
		}

		// Lấy dữ liệu cartItems từ db
		List<CartItem> list = cartItemService.findByCartId(cart_cur.getId());

		// Tính tổng số tiền phải trả và tổng tiền ship
		double totalCost = 0;
		double shipCost = 0;
		double payCost = 0;
		for (CartItem cartItem : list) {
			shipCost += 10000;
			totalCost += cartItem.getCount() * cartItem.getProduct().getPromotionalPrice();
		}
		payCost = totalCost + shipCost;

		// Gắn các cartItems và tổng tiền lên view
		req.setAttribute("cart_items_list", list);
		req.setAttribute("style_service", styleValueService);
		req.setAttribute("totalCost", totalCost);
		req.setAttribute("shipCost", shipCost);
		req.setAttribute("payCost", payCost);

		// Điều hướng
		req.getRequestDispatcher("/views/customer/checkout.jsp").forward(req, resp);
	}

	private void SubmitCheckout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy thông tin cart hiện tại từ session
		HttpSession session = req.getSession();
		User account_cur = (User) session.getAttribute("account");
		Cart cart_cur = (Cart) session.getAttribute("cart");

		// Tính tổng số tiền phải trả và tổng tiền ship
		double totalCost = 0;
		double shipCost = 0;
		double payCost = 0;

		// Nếu chưa có cart thì tạo cart mới trên session và insert cart vào db
		if (true) {
			cart_cur = new Cart();
			cart_cur.setUserId(account_cur.getId());
			cart_cur.setStore(2);
			try {
				cartService.insert(cart_cur);
			} catch (Exception e) {
				Constant.setAlert(req, resp, "error", "Đã xảy ra lỗi, không thể thêm sản phẩm vào giỏ hàng!");
				req.getRequestDispatcher("/views/customer/cart.jsp").forward(req, resp);
				return;
			} finally {
				// Lưu cart vào session
				cart_cur = cartService.findLast();
				session.setAttribute("cart", cart_cur);
			}
		}
		
		Constant.setAlertSession(req, resp, "success","Đặt hàng thành công!");
		resp.sendRedirect(req.getContextPath()+"/home");

	}

}
