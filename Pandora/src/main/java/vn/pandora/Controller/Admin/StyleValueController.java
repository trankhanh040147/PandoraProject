package vn.pandora.Controller.Admin;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.html.HTMLStyleElement;

import vn.pandora.Model.StyleValue;
import vn.pandora.Model.User;
import vn.pandora.Service.iStyleService;
import vn.pandora.Service.iStyleValueService;
import vn.pandora.Service.Impl.StyleServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class StyleValueController
 */
@WebServlet(urlPatterns = { "/admin/style-value", "/admin/style-value/add", "/admin/style-value/update",
		"/admin/style-value/delete" })
public class StyleValueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	iStyleValueService styleValueService = new StyleValueServiceImpl();
	iStyleService styleService = new StyleServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String url = req.getRequestURL().toString();

		// Trang chủ cho vendor
		if (url.endsWith("style-value")) {
			StyleValueList(req, resp);
		} else if (url.endsWith("update")) {
			FormUpdate(req, resp);
		} else if (url.endsWith("delete")) {
			DeleteStyleValue(req, resp);
		} else if (url.endsWith("add")) {
			req.getRequestDispatcher("/views/admin/styleValue/styleValue-insert.jsp").forward(req, resp);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String url = req.getRequestURL().toString();

		// Trang chủ cho vendor
		if (url.endsWith("update")) {
			UpdateStyleValue(req, resp);
		} else if (url.endsWith("add")) {
			InsertStyleValue(req, resp);
		}
	}

	private void FormUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");

		Integer id = Integer.parseInt(req.getParameter("id"));

		StyleValue sv = styleValueService.getOne(id);

		req.setAttribute("style_value", sv);
		req.getRequestDispatcher("/views/admin/styleValue/styleValue-update.jsp").forward(req, resp);
	}

	private void DeleteStyleValue(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		styleValueService.delete(id);

		Constant.setAlertSession(req, resp, "success", "Đã xoá thuộc tính thành công!");
		resp.sendRedirect(req.getContextPath() + "/admin/style-value");
	}

	private void StyleValueList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");

		// Gọi service lấy danh sách styleValue
		List<StyleValue> list = styleValueService.getAll(0, 200);

		// Gắn dữ liệu lên view
		req.setAttribute("styleValue_list", list);

		// Điều hướng jsp
		req.getRequestDispatcher("/views/admin/styleValue/styleValue-list.jsp").forward(req, resp);

	}

	private void InsertStyleValue(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		Integer styleId = Integer.parseInt(req.getParameter("style_id"));
		String name = req.getParameter("name");

		StyleValue styleValue = new StyleValue();
		styleValue.setName(name);
		styleValue.setStyleId(styleId);
		styleValue.setStyle(styleService.getOne(styleId));

		styleValueService.insert(styleValue);

		Constant.setAlertSession(req, resp, "success", "Thêm thuộc tính sản phẩm thành công!");
		resp.sendRedirect(req.getContextPath() + "/admin/style-value");
	}

	private void UpdateStyleValue(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.parseInt(req.getParameter("style_value_id"));
		Integer styleId = Integer.parseInt(req.getParameter("style_id"));
		String name = req.getParameter("name");

		StyleValue styleValue = styleValueService.getOne(id);
		styleValue.setName(name);
		styleValue.setStyleId(styleId);
		styleValue.setStyle(styleService.getOne(styleId));

		System.out.println(name);

		styleValueService.update(styleValue);

		Constant.setAlertSession(req, resp, "success", "Cập nhật thuộc tính thành công!");
		resp.sendRedirect(req.getContextPath() + "/admin/style-value/update?id=" + String.valueOf(id));
	}

}
