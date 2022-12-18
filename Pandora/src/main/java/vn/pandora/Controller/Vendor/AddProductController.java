package vn.pandora.Controller.Vendor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vn.pandora.DAO.Impl.CategoryDaoImpl;
import vn.pandora.Model.Category;
import vn.pandora.Model.StyleValue;
import vn.pandora.Model.User;
import vn.pandora.Service.Impl.CategoryServiceImpl;
import vn.pandora.Service.Impl.StoreServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet(urlPatterns = {"/vendor/addProduct"})
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StoreServiceImpl storeServiceImpl= new  StoreServiceImpl();
       CategoryServiceImpl categoryService= new CategoryServiceImpl();
      StyleValueServiceImpl styleService= new StyleValueServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		User users = (User) session.getAttribute("account");
		List<Category>listCategory= new ArrayList<Category>();
		List<StyleValue>listStyleColor= new ArrayList<StyleValue>();
		listCategory=categoryService.getAll();
		listStyleColor = styleService.getAlLById(1);//màu
		System.out.println(listCategory);
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("listStyle", listStyleColor);
		req.getRequestDispatcher("/views/vendor/ProductAdd.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String filenamecover = "";
		Part part1 = request.getPart("featured_image");
	    
	    if(part1.getSubmittedFileName()!="") 
	    {
			//Tạo thư mục lưu file nếu chưa tồn tại
			String realPath1 = Constant.DIR;
			
			if (!Files.exists(Paths.get(realPath1))) {
				Files.createDirectory(Paths.get(realPath1));
			}
			
			//Upload file bằng Multipart
			filenamecover = Paths.get(part1.getSubmittedFileName()).getFileName().toString(); 
			part1.write(realPath1 + "/" + filenamecover);
		}
	    String descripsion= request.getParameter("descripsion");
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    
	}

}
