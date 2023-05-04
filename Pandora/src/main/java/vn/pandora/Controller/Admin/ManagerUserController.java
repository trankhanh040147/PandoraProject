package vn.pandora.Controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.pandora.Model.User;
import vn.pandora.Service.Impl.UserServiceImpl;


@WebServlet(urlPatterns = {"/admin/ManagerUser"})
public class ManagerUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      UserServiceImpl userServiceImpl = new UserServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser= new ArrayList<User>();
		listUser= userServiceImpl.getAll(0, 100);
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/views/admin/user.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
