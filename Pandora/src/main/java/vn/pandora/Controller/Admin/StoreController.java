package vn.pandora.Controller.Admin;

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

import vn.pandora.Model.Store;
import vn.pandora.Model.User;
import vn.pandora.Service.Impl.StoreServiceImpl;
import vn.pandora.Util.Constant;

/**
 * Servlet implementation class ListStoreController
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = { "/admin/store", "/admin/store/detail", "/admin/store/permit", "/admin/store/ban" })
public class StoreController extends HttpServlet {
	StoreServiceImpl storeServiceImpl = new StoreServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String url = req.getRequestURL().toString();

		// Trang chủ cho vendor
		if (url.endsWith("/store")) {
			StoreList(req, resp);
		}
		// Trang chủ cho vendor
		else if (url.endsWith("/permit")) {
			permiStore(req, resp);
		} 
		else if (url.endsWith("/ban")) {
			banStore(req, resp);
		} 
		else if (url.endsWith("/detail")) {
			StoreDetail(req, resp);
		} 

	}

	private void StoreList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Store> listStore = storeServiceImpl.getAll(0, 100);

		req.setAttribute("listStore", listStore);

		req.getRequestDispatcher("/views/admin/store/store-list.jsp").forward(req, resp);
	}
	private void permiStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("storeId"));
		Store store= new Store();
		store= storeServiceImpl.GetOne(id);
		storeServiceImpl.permit(store);
		resp.sendRedirect(req.getContextPath()+"/admin/store");
	}	
	private void banStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("storeId"));
		Store store= new Store();
		store= storeServiceImpl.GetOne(id);
		storeServiceImpl.revoke(store);
		resp.sendRedirect(req.getContextPath()+"/admin/store");
	}
	

	private void StoreDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer storeId = Integer.parseInt(req.getParameter("storeId"));

		Store store = storeServiceImpl.GetOne(storeId);

		req.setAttribute("storeDetail", store);

		req.getRequestDispatcher("/views/admin/store/store-detail.jsp").forward(req, resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURL().toString();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
if(url.endsWith("detail")) {
	

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
   resp.sendRedirect(req.getContextPath()+"/admin/store");

}

	}

}
