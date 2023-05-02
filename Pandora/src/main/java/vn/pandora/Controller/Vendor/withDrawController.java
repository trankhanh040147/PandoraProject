package vn.pandora.Controller.Vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.pandora.Model.Store;
import vn.pandora.Model.Transaction;
import vn.pandora.Model.User;
import vn.pandora.Service.Impl.StoreServiceImpl;
import vn.pandora.Service.Impl.TransactionServiceImpl;
import vn.pandora.Util.Constant;


@WebServlet(urlPatterns = {"/vendor/Withdraw"})
public class withDrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StoreServiceImpl storeServiceImpl = new StoreServiceImpl();
    TransactionServiceImpl transactionServiceImpl =new  TransactionServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		User users = (User) session.getAttribute("account");
		
		List<Store> listStoreId = new ArrayList<Store>();
		listStoreId = storeServiceImpl.GetStoreByownerId(0,200,users.getId());
		req.setAttribute("listStoreId", listStoreId);
		req.getRequestDispatcher("/views/vendor/Withdraw.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			User users = (User) session.getAttribute("account");
			int storeId= Integer.parseInt(request.getParameter("storeId"));
			int amount=  Integer.parseInt(request.getParameter("amount"));
			String password = request.getParameter("password");
			if (password.equals(users.getPassword())) {
				Transaction transaction= new Transaction(users.getId(),storeId,true,amount);
				transactionServiceImpl.Add(transaction);
				Constant.setAlertSession(request, response, "success", "Rút tiền thành công");
				response.sendRedirect(request.getContextPath() + "/vendor/Transaction");
			}
			else {
				String test="Rút tiền  không thành công ! Bạn cần nhập đúng mật khẩu tài khoản của bạn!";
		    	request.setAttribute("alert3", test);
				request.getRequestDispatcher("/views/vendor/Withdraw.jsp").forward(request, response);
			}
		} catch (Exception e) {
			String test="Rút tiền không thành công ! Bạn cần nhập đầy đủ thông tin!";
	    	request.setAttribute("alert3", test);
			request.getRequestDispatcher("/views/vendor/Withdraw.jsp").forward(request, response);

		}
		
	}

}
