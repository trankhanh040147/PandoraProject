package vn.pandora.Controller.Account;

import java.io.IOException;

import javax.security.auth.login.AccountException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.pandora.Model.Cart;
import vn.pandora.Model.User;
import vn.pandora.Service.iCartService;
import vn.pandora.Service.iUserService;
import vn.pandora.Service.Impl.CartServiceImpl;
import vn.pandora.Service.Impl.UserServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/login", "/login/submit", "/login/waiting" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	iUserService userService = new UserServiceImpl();
	iCartService cartService = new CartServiceImpl();


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();

		// Xử lí các patterns
		if (url.contains("login/waiting")) {
			loginWaiting(req, resp);
		} else if (url.contains("login/submit")) {
			loginSubmit(req, resp);
		}
		// url = localhost:8080/pandora/login
		else if (url.endsWith("login")) {
			loginCheck(req, resp);
		}

	}

	protected void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Chuyến đến form đăng nhập khi click vào nút đăng nhập
		req.getRequestDispatcher("/views/web/account/login.jsp").forward(req, resp);
	}

	protected void loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Xử lí check tài khoản trên session và cookie
		HttpSession session = req.getSession(false);

		// Nếu đã có session "account" thì chuyển sang sq waiting
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/login/waiting");
			return;
		}

		// Nếu không có session thì bắt đầu kiểm tra cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// Nếu trong cookie có cookie tên "username" lưu tài khoản của người dùng thì tự
				// động đăng nhập bằng tài khoản đó
				if (cookie.getName().equals("username") && cookie.getValue() != null
						&& !("").equals(cookie.getValue())) {
					String username = cookie.getValue();
					User users = userService.findByEmail(username);
					// Gắn tài khoản đã lưu trong cookie vào session "username"
					session = req.getSession(true);
					session.setAttribute("account", users);
					resp.sendRedirect(req.getContextPath() + "/login/waiting");
					return;
				}
			}
		}

		loginPage(req, resp);
	}

	private void loginWaiting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		// Nếu có session "account" đã lưu thông tin đăng nhập
		if (session != null && session.getAttribute("account") != null) {

			// Gắn tài khoản đã lưu trên session "account"
			User u = (User) session.getAttribute("account");

			Constant.setAlert(req, resp, "success",
					"Đăng nhập thành công, xin chào mừng +" + u.getLastname() + " " + u.getLastname() + "!");

			if (("customer").equals(u.getRole())) {
				// Load dữ liệu của customer và lưu trên session
				LoadCustomerData(req, resp);
				resp.sendRedirect(req.getContextPath() + "/home");
			}
			if (("vendor").equals(u.getRole())) {
				// Lưu tên đăng nhập vào session "username"
				resp.sendRedirect(req.getContextPath() + "/vendor/home");
			}
			if (("admin").equals(u.getRole())) {
				// Lưu tên đăng nhập vào session "username"
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			}

		}

	}

	private void LoadCustomerData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//Tìm thông tin giỏ hàng của khách hàng
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("account");

		Cart cart = cartService.findLastByUserId(u.getId());
		
		//Nếu khách hàng có cart rồi thì lưu cart lên session
		if(cart != null) {
			session.setAttribute("cart", cart);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		boolean isRememberMe = false;
		String remember = req.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}

		String alertMsg = "";

		// Thông báo lỗi nếu username hoặc password để trống

		if (username.isEmpty() || password.isEmpty()) {
			Constant.setAlert(req, resp, "error", "Không được để trống email hoặc password!");
			req.getRequestDispatcher("/views/web/account/login.jsp").forward(req, resp);
			return;
		}

		// Gọi service và kiểm tra thông tin tài khoản, mật khẩu

		User account = userService.login(username, password);

		if (account != null) {
			// Nếu đăng nhập thành công --> Lưu tài khoản trên Session và Cookie
			HttpSession session = req.getSession(true);
			session.setAttribute("account", account);

			// Nếu có chọn "Nhớ mật khẩu" thì lưu username và password vào cookie
			if (isRememberMe) {
				saveRememberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath() + "/login/waiting");
		} else {
			// Tài khoản hoặc mật khẩu không đúng --> báo lỗi sai tài khoản - mật khẩu
			Constant.setAlert(req, resp, "error", "Email hoặc mật khẩu không đúng!");
			req.getRequestDispatcher("/views/web/account/login.jsp").forward(req, resp);
		}
	}

	private void loginSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	private void saveRememberMe(HttpServletResponse resp, String username) throws ServletException, IOException {

		// Lưu tài khoản lên cookie
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);

		// set thời gian hết hạn của cookie là 5 ngày
		cookie.setMaxAge(5 * 24 * 60 * 60);

		// Thêm cookie vào resp
		resp.addCookie(cookie);

	}

}
