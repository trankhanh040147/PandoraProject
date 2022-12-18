package vn.pandora.Controller.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.cj.protocol.PacketReceivedTimeHolder;

import vn.pandora.Model.User;
import vn.pandora.Service.iUserService;
import vn.pandora.Service.Impl.UserServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class InfoController
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 5, // 5MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = { "/customer/account/profile", "/customer/account/password" })
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	iUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();

		// Thay đổi thông tin profile
		if (url.contains("/customer/account/profile")) {
			req.getRequestDispatcher("/views/customer/account/edit-profile.jsp").forward(req, resp);
		}
		// Thay đổi thông tin mật khẩu
		else if (url.contains("/customer/account/password")) {
			req.getRequestDispatcher("/views/customer/account/edit-password.jsp").forward(req, resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();

		// Thay đổi thông tin profile
		if (url.contains("/customer/account/profile")) {
			EditProfile(req, resp);
		}
		// Thay đổi thông tin mật khẩu
		else if (url.contains("/customer/account/password")) {
			EditPassword(req, resp);
		}
	}

	private void EditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set content
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy account từ session
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("account");

		// Lấy giá trị các parameter từ request
		String lastName = req.getParameter("lastname");
		String firstName = req.getParameter("firstname");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String idCard = req.getParameter("id_card");

		// Set thư mục hình ảnh
		String imgDir = "avatar";

		// Cập nhật hình ảnh
		try {
			Part part = req.getPart("avatar");
			System.out.println(part.getSubmittedFileName());
			if (part.getSubmittedFileName() != "") {
				// Tạo thư mục lưu file nếu chưa tồn tại
				String realPath = Constant.DIR + "/" + imgDir;

				if (!Files.exists(Paths.get(realPath))) {
					Files.createDirectory(Paths.get(realPath));
				}

				// Upload file bằng Multipart
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				part.write(realPath + "/" + filename);

				user.setAvatar(imgDir + "/" + filename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Gọi service cập nhật thông tin
		try {
			user.setFirstname(firstName);
			user.setLastname(lastName);
			user.setAddress(address);
			user.setEmail(email);
			user.setPhone(phone);
			user.setId_card(idCard);
			
			userService.editCustomer(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Thông báo alert và điều hướng
			Constant.setAlert(req, resp, "success", "Cập nhật thông tin thành công!");
			req.getRequestDispatcher("/views/customer/account/edit-profile.jsp").forward(req, resp);
		}
	}

	private void EditPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set content
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy account từ session
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("account");

		// Lấy giá trị các parameter từ request
		String oldPass = req.getParameter("current_password");
		String newPass = req.getParameter("new_password");
		String confirmPass = req.getParameter("confirm_password");
		
		// Exception 1: Nhập sai mật khẩu hiện tại
		if(!oldPass.equals(user.getPassword())) {
			Constant.setAlert(req, resp, "error", "Mật khẩu hiện tại không đúng!");
			req.getRequestDispatcher("/views/customer/account/edit-password.jsp").forward(req, resp);
			return;
		}
			
		// Exception 2: Nhập mật khẩu mới và mật khẩu xác nhận không giống
		if(!newPass.equals(confirmPass)) {
			Constant.setAlert(req, resp, "error", "Mật khẩu mới và mật khẩu xác nhận không khớp!");
			req.getRequestDispatcher("/views/customer/account/edit-password.jsp").forward(req, resp);
			return;
		}
		
		// Exception 3: Nhập mật khẩu mới giống mật khẩu cũ
		if(newPass.equals(oldPass)) {
			Constant.setAlert(req, resp, "error", "Mật khẩu mới và mật khẩu cũ giống nhau!");
			req.getRequestDispatcher("/views/customer/account/edit-password.jsp").forward(req, resp);
			return;
		}
		
		// Exception 4: Nhập mật khẩu mới không đủ mức độ bảo mật
		// Exception 4.1: Nhập mật khẩu không có số
		if(!newPass.matches(".*\\d.*")) {
			Constant.setAlert(req, resp, "error", "Mật khẩu mới không đủ bảo mật!");
			req.getRequestDispatcher("/views/customer/account/edit-password.jsp").forward(req, resp);
			return;
		}
		
		// Gọi service cập nhật thông tin
		try {
			user.setPassword(newPass);
			userService.editCustomer(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Thông báo alert và điều hướng
			Constant.setAlert(req, resp, "success", "Cập nhật mật khẩu thành công!");
			req.getRequestDispatcher("/views/customer/account/edit-password.jsp").forward(req, resp);
		}
	}

}
