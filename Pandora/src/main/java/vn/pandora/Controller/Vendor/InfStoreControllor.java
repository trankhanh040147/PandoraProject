package vn.pandora.Controller.Vendor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.pandora.Model.Store;
import vn.pandora.Service.Impl.StoreServiceImpl;
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
		System.out.println(id);
		req.setAttribute("storeDetail", store);
		req.getRequestDispatcher("/views/vendor/StoreInf.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
