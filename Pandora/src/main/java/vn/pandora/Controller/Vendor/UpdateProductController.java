package vn.pandora.Controller.Vendor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vn.pandora.Model.Category;
import vn.pandora.Model.Product;
import vn.pandora.Model.Store;
import vn.pandora.Model.StyleValue;
import vn.pandora.Model.User;
import vn.pandora.Service.Impl.CategoryServiceImpl;
import vn.pandora.Service.Impl.ProductServiceImpl;
import vn.pandora.Service.Impl.StoreServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;
import vn.pandora.Util.Constant;
import vn.pandora.Util.UtilClass;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = "/vendor/updateProduct")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StoreServiceImpl storeServiceImpl = new StoreServiceImpl();
	CategoryServiceImpl categoryService = new CategoryServiceImpl();
	StyleValueServiceImpl styleService = new StyleValueServiceImpl();
	ProductServiceImpl productService = new ProductServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		User users = (User) session.getAttribute("account");
		List<Category> listCategory = new ArrayList<Category>();
		List<StyleValue> listStyleColor = new ArrayList<StyleValue>();
		List<StyleValue> listStylesize = new ArrayList<StyleValue>();
		List<StyleValue> listStyletype = new ArrayList<StyleValue>();
		List<Store> listStoreId = new ArrayList<Store>();
		Product product = new Product();
		int id = Integer.parseInt(req.getParameter("pid"));

		listCategory = categoryService.getAll();
		listStyleColor = styleService.getAlLById(1);// màu
		listStylesize = styleService.getAlLById(2);// size
		listStyletype = styleService.getAlLById(3);// type
		product = productService.GetOne(id);

		listStoreId = storeServiceImpl.GetStoreByownerId(0,200,users.getId());
		req.setAttribute("listStoreId", listStoreId);
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("listStyleColor", listStyleColor);
		req.setAttribute("listStylesize", listStylesize);
		req.setAttribute("listStyletype", listStyletype);
		req.setAttribute("utilClass", new UtilClass());
		req.setAttribute("product", product);

		req.getRequestDispatcher("/views/vendor/updateProduct.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Ktra
		Product productTemp =  productService.GetOne(id);
		String filenamecover = productTemp.getListImages() != null ? productTemp.getListImages().get(0) : "";

		Part part1 = request.getPart("featured_image");

		if (part1.getSubmittedFileName() != "") {
			// Tạo thư mục lưu file nếu chưa tồn tại
			String realPath1 = Constant.DIR;

			if (!Files.exists(Paths.get(realPath1))) {
				Files.createDirectory(Paths.get(realPath1));
			}

			// Upload file bằng Multipart
			filenamecover = Paths.get(part1.getSubmittedFileName()).getFileName().toString();
			part1.write(realPath1 + "/" + filenamecover);
		}
		List<String> listImages = new ArrayList<String>();
		String descripsion = request.getParameter("descripsion");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int category = Integer.parseInt(request.getParameter("category"));
		int storeId = Integer.parseInt(request.getParameter("storeId"));
		int color = Integer.parseInt(request.getParameter("Style-color"));
		int size = Integer.parseInt(request.getParameter("Style-size"));
		int type = Integer.parseInt(request.getParameter("Style-type"));
		
		List<Integer> styleVaLueIds = new ArrayList<Integer>();
		styleVaLueIds.add(color);
		styleVaLueIds.add(size);
		styleVaLueIds.add(type);
		double price = Double.parseDouble(request.getParameter("price"));
		double promotionalPrice = Double.parseDouble(request.getParameter("promotionalPrice"));
		boolean isSelling = Boolean.parseBoolean(request.getParameter("isSelling"));
		listImages.add(filenamecover);
		Product product = new Product(name, descripsion, price, promotionalPrice, quantity, listImages, category,
				styleVaLueIds, storeId, isSelling);
		product.setId(id);
		System.out.println(product.toString());
		productService.Update(product);
		response.sendRedirect(request.getContextPath() + "/vendor/ListProduct");
	}

}
