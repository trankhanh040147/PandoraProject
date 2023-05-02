package vn.pandora.Controller.Account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.pandora.Model.User;
import vn.pandora.Service.iUserService;
import vn.pandora.Service.Impl.UserServiceImpl;
import vn.pandora.Util.Constant;

@WebServlet(urlPatterns = { "/register/customer", "/register/vendor", "/register/customer/submit", "/register/vendor/submit"})

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	iUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString(); 
		
		// Trang đăng ký cho customer
		if (url.endsWith("/register/customer")) {
			req.getRequestDispatcher("/views/web/account/register-customer.jsp").forward(req, resp);
		}
		// Trang chủ cho vendor
		else if (url.endsWith("/register/vendor")) {
			req.getRequestDispatcher("/views/web/account/register-vendor.jsp").forward(req, resp);
		} 
		// Xử lí đăng ký cho customer
		else if (url.endsWith("/register/customer/submit")) {
			RegisterCustomer(req,resp);
			req.getRequestDispatcher("/views/web/account/register-customer.jsp").forward(req, resp);
		} 
		// Xử lí đăng ký cho vendor
		else if (url.endsWith("/register/vendor/submit")) {
			RegisterVendor(req,resp);
			req.getRequestDispatcher("/views/web/account/register-vendor.jsp").forward(req, resp);
		} 
	}

	private void RegisterVendor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Lấy dữ liệu từ view
		String lastName = req.getParameter("lastname");
		String firstName = req.getParameter("firstname");
		String email = req.getParameter("email_reg");
		String phone = req.getParameter("phone");
		String idCard = req.getParameter("id_card");
		String address = req.getParameter("address");
		String password = req.getParameter("password_reg");
		String passwordConfirm = req.getParameter("password_confirm");

		// Kiểm tra lỗi: "Không được bỏ trống thông tin!"
		if ("".equals(lastName) || "".equals(firstName) || "".equals(email) || "".equals(phone) || "".equals(password)
				|| "".equals(passwordConfirm) || "".equals(idCard) || "".equals(address) ) {
			Constant.setAlert(req, resp, "error", "Không được bỏ trống thông tin");
			req.getRequestDispatcher("/views/web/account/register-vendor.jsp").forward(req, resp);
			return;
		}

		// Kiểm tra lỗi: "Mật khẩu và xác nhận mật khẩu không trùng khớp!"
		if (!password.equals(passwordConfirm)) {
			Constant.setAlert(req, resp, "error", "Mật khẩu và xác nhận mật khẩu không khớp");
			req.getRequestDispatcher("/views/web/account/register-vendor.jsp").forward(req, resp);
			return;
		}

		// Kiểm tra lỗi: "Nhập không đúng định dạng" --> (Sql)

		// Gọi service tạo tài khoản
		User user = new User();
		user.setLastname(lastName);
		user.setFirstname(firstName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);
		user.setId_card(idCard);
		user.setPassword(password);

		try {
			userService.registerVendor(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Thông báo tạo tài khoản thành công và trả về trang chủ
		Constant.setAlert(req, resp, "success", "Tạo tài khoản thành công!");
		req.getRequestDispatcher("/views/web/account/login.jsp").forward(req, resp);

	}

	private void RegisterCustomer(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// Lấy dữ liệu từ view
		String lastName = req.getParameter("lastname");
		String firstName = req.getParameter("firstname");
		String email = req.getParameter("email_reg");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password_reg");
		String passwordConfirm = req.getParameter("password_confirm");
		
		// Kiểm tra lỗi: "Không được bỏ trống thông tin!"
		if("".equals(lastName) || "".equals(firstName) || "".equals(email) || "".equals(phone) || "".equals(password)|| "".equals(passwordConfirm)) {
			Constant.setAlert(req, resp, "error", "Không được bỏ trống thông tin");
			req.getRequestDispatcher("/views/web/account/register-customer.jsp").forward(req, resp);
			return;
		}

		// Kiểm tra lỗi: "Mật khẩu và xác nhận mật khẩu không trùng khớp!"
		if(! password.equals(passwordConfirm)) {
			Constant.setAlert(req, resp, "error", "Mật khẩu và xác nhận mật khẩu không khớp");
			req.getRequestDispatcher("/views/web/account/register-customer.jsp").forward(req, resp);
			return;
		}

		// Kiểm tra lỗi: "Nhập không đúng định dạng" --> (Sql)

		// Gọi service tạo tài khoản
		User user = new User();
		user.setLastname(lastName);
		user.setFirstname(firstName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		
		try {
			userService.registerCustomer(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Thông báo tạo tài khoản thành công và trả về trang chủ
		Constant.setAlert(req, resp, "success", "Tạo tài khoản thành công!");
		req.getRequestDispatcher("/views/web/account/login.jsp").forward(req, resp);
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String fullname = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		boolean Gender = Boolean.parseBoolean(request.getParameter("Gender"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sdt = request.getParameter("sdt");
		String diachi = request.getParameter("address");
		String email = request.getParameter("email");

//		Account account = new Account(username, password, false, true);
//		accoutService.Add(account);
//		Client client = new Client(username, fullname, ngaysinh, Gender, sdt, email, diachi);
//		clientService.Add(client);
//		response.sendRedirect(request.getContextPath() + "/Login");

	}

}
