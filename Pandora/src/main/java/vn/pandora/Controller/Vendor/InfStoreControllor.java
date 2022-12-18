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
import javax.servlet.http.Part;

import vn.pandora.Model.Store;
import vn.pandora.Service.Impl.StoreServiceImpl;
import vn.pandora.Util.Constant;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = "/vendor/informationStore")
public class InfStoreControllor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 StoreServiceImpl storeServiceImpl = new StoreServiceImpl();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		int id=Integer.parseInt(req.getParameter("sid"));
		Store store= storeServiceImpl.GetOne(id);
		
		req.setAttribute("storeDetail", store);
		req.getRequestDispatcher("/views/vendor/StoreInf.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
	
		Part part = req.getPart("avatar");
		int id=Integer.parseInt(req.getParameter("storeId"));
		Store store= storeServiceImpl.GetOne(id);
		
		String filenameavatar = store.getAvatar();
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
		String filenamecover =store.getCover();
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
		String filenamefeatured = store.getFeatured_image();
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
	    
	    String name= req.getParameter("name");
	    String  bio=req.getParameter("bio");
	   
	    
	   boolean isOpen= Boolean.parseBoolean(req.getParameter("isOpen"));
	   
	   storeServiceImpl.Update( name,bio, isOpen, filenameavatar, filenamecover,filenamefeatured , id);
	   resp.sendRedirect(req.getContextPath()+"/vendor/listStore");
	}

}
