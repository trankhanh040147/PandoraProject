package vn.pandora.Controller.Customer.Product;

import java.io.IOException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioSystem;

import vn.pandora.DAO.iProductDao;
import vn.pandora.Model.Product;
import vn.pandora.Model.Style;
import vn.pandora.Model.StyleValue;
import vn.pandora.Model.User;
import vn.pandora.Service.iProductService;
import vn.pandora.Service.iStyleService;
import vn.pandora.Service.iStyleValueService;
import vn.pandora.Service.Impl.ProductServiceImpl;
import vn.pandora.Service.Impl.StyleServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class ProductHomeController
 */
@WebServlet(urlPatterns = { "/product/detail" })
public class ProductHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	iProductService productService = new ProductServiceImpl();
	iStyleValueService styleValueService = new StyleValueServiceImpl();
	iStyleService styleService = new StyleServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();

		// Xử lí hiển thị chi tiết sản phẩm
		if (url.endsWith("detail")) {
			ProductDetail(req, resp);
			req.getRequestDispatcher("/views/web/product/product-detail.jsp").forward(req, resp);
		}

	}

	private void ProductDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Lấy id của product từ view
		Integer productId = Integer.parseInt(req.getParameter("product_id"));

		// Gọi service lấy dữ liệu product
		Product product = productService.GetOne(productId);

		// Xử lí lọc danh sách các Styles
		Integer totalStyles = 0;
		Style tempStyle = new Style();
		Style style1 = new Style(0);
		Style style2 = new Style(0);
		Style style3 = new Style(0);
		StyleValue tempStyleValue = new StyleValue();
		List<StyleValue> styleValues1 = new ArrayList<StyleValue>();
		List<StyleValue> styleValues2 = new ArrayList<StyleValue>();
		List<StyleValue> styleValues3 = new ArrayList<StyleValue>();

		for (Integer styleValueId : product.getStyleValueIds()) {
			tempStyleValue = styleValueService.getOne(styleValueId);
			tempStyle = styleService.getOne(tempStyleValue.getStyleId());

			// Xử lí style
			if (style1.getId() == 0) {
				totalStyles++;
				style1 = tempStyle;
			} else if (style2.getId() == 0 && tempStyle.getId() != style1.getId()) {
				totalStyles++;
				style2 = tempStyle;
			} else if (style3.getId() == 0 && tempStyle.getId() != style2.getId()
					&& tempStyle.getId() != style1.getId()) {
				totalStyles++;
				style3 = tempStyle;
			}

			// Xử lí stylevalue
			if (tempStyleValue.getStyleId() == style1.getId()) {
				styleValues1.add(tempStyleValue);
			} else if (tempStyleValue.getStyleId() == style2.getId()) {
				styleValues2.add(tempStyleValue);
			} else if (tempStyleValue.getStyleId() == style3.getId()) {
				styleValues3.add(tempStyleValue);
			}
		}

		// Đưa dữ liệu của product về view
		req.setAttribute("product", product);
		req.setAttribute("style1", style1);
		req.setAttribute("style2", style2);
		req.setAttribute("style3", style3);
		req.setAttribute("style1_list", styleValues1);
		req.setAttribute("style2_list", styleValues2);
		req.setAttribute("style3_list", styleValues3);

//		System.out.println(style1.toString());
//		System.out.println(style2.toString());
//		System.out.println(style3.toString());
//		for (StyleValue styleValue : styleValues1) {
//			System.out.println(styleValue.toString());
//		}
//		for (StyleValue styleValue : styleValues2) {
//			System.out.println(styleValue.toString());
//		}
//		for (StyleValue styleValue : styleValues3) {
//			System.out.println(styleValue.toString());
//		}

	}

}
