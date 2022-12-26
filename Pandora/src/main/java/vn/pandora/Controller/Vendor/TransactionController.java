package vn.pandora.Controller.Vendor;

import java.io.IOException;
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
import vn.pandora.Service.Impl.TransactionServiceImpl;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet(urlPatterns = {"/vendor/Transaction"})
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       TransactionServiceImpl transactionServiceImpl= new TransactionServiceImpl();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		LoadTransaction(req, resp);
		req.getRequestDispatcher("/views/vendor/Transaction.jsp").forward(req, resp);
        
	}

	
	private void LoadTransaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set số item mỗi trang
				int ItemsPerPage = 5;

				// Set tổng số trang hiển thị trên view
				int PagesDisplay = 9;

				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */
				// Lấy dữ liệu từ view
				String indexPage = req.getParameter("index");
				// Xử lứ trường hợp không truyền vào index
				if (indexPage == null) {
					indexPage = "1";
				}
				int index = Integer.parseInt(indexPage);
				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */

				/* Phân trang */

				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */
				// Lấy dữ liệu theo số trang
				HttpSession session = req.getSession();
				User users = (User) session.getAttribute("account");
				List<Transaction> TransactionList = transactionServiceImpl.GetAllByIdOwner((index - 1) * ItemsPerPage, ItemsPerPage,
						users.getId());

				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */

				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */
				// Đếm tổng số items

				// Cách 2: Lấy danh sách tất cả items và đếm số items
				List<Transaction> TransactionListAll = transactionServiceImpl.GetAllByIdOwner(0, 200, users.getId());
				int totalItems = TransactionListAll.size();
				
				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */

				// Tìm trang cuối cùng của toàn bộ danh sách items
				int lastPage = totalItems / ItemsPerPage + (totalItems % ItemsPerPage != 0 ? 1 : 0);

				// Xác định trang đầu (head) và trang cuối (tail)
				int head = index - PagesDisplay / 2;
				int tail = index + PagesDisplay / 2;
				head = head >= 1 ? head : 1;
				tail = tail <= lastPage ? tail : lastPage;
				head = tail - PagesDisplay + 1 >= 1 ? tail - PagesDisplay + 1 : head;
				tail = head + PagesDisplay - 1 <= lastPage ? head + PagesDisplay - 1 : tail;

				/* Phân trang */

				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */
				// Truyền dữ liệu lên view
				req.setAttribute("index", index);
				req.setAttribute("startPage", head);
				req.setAttribute("endPage", tail);
				req.setAttribute("lastPage", lastPage);

				// Dữ liệu xử lí
				req.setAttribute("TransactionList", TransactionList);
				
				/*
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				 */
	}

}
