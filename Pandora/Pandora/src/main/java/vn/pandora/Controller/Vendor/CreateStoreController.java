package vn.pandora.Controller.Vendor;

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

import vn.pandora.Model.Store;
import vn.pandora.Model.User;
import vn.pandora.Service.Impl.StoreServiceImpl;
import vn.pandora.Util.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = {"/vendor/createStore"})
public class CreateStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StoreServiceImpl storeservice = new StoreServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.getRequestDispatcher("/views/vendor/NewStore.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name= req.getParameter("name");
		String bio= req.getParameter("bio");
		String filenameavatar = "";
		Part part = req.getPart("avatar");
	    
	    if(part.getSubmittedFileName()!="") 
	    {
			//Tạo thư mục lưu file nếu chưa tồn tại
			String realPath = Constant.DIR;
			
			if (!Files.exists(Paths.get(realPath))) {
				Files.createDirectory(Paths.get(realPath));
			}
			
			//Upload file bằng Multipart
			 filenameavatar = Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
			part.write(realPath + "/" + filenameavatar);
		}
		String filenamecover = "";
		Part part1 = req.getPart("cover");
	    
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
		String filenamefeatured = "";
		Part part2 = req.getPart("featured_image");
	    
	    if(part2.getSubmittedFileName()!="") 
	    {
			//Tạo thư mục lưu file nếu chưa tồn tại
			String realPath2 = Constant.DIR;
			
			if (!Files.exists(Paths.get(realPath2))) {
				Files.createDirectory(Paths.get(realPath2));
			}
			
			//Upload file bằng Multipart
			filenamefeatured = Paths.get(part2.getSubmittedFileName()).getFileName().toString(); 
			part2.write(realPath2 + "/" + filenamefeatured);
		}
	    if (filenameavatar!="" && filenamecover!="" && filenamefeatured!="" && name!="" && bio!="") {
	    HttpSession session = req.getSession();
		User users = (User) session.getAttribute("account");
	
		Store store = new Store(name,bio,users.getId(),filenameavatar,filenamecover,filenamefeatured);
		storeservice.Add(store);
		resp.sendRedirect(req.getContextPath()+"/vendor/home");}
	    else {
	    	String test="Tạo cửa hàng không thành công ! Bạn cần nhập đầy đủ thông tin!";
	    	req.setAttribute("alert", test);
			req.getRequestDispatcher("/views/vendor/NewStore.jsp").forward(req, resp);
	    }
	}

}
