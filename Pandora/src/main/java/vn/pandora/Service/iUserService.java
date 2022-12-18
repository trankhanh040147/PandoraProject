package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.User;

public interface iUserService {

	User login(String email, String passwd);

	User findByEmail(String email);
	
	User findById(int id);

	void registerCustomer(User user);

	void registerVendor(User user);

	List<User> getAll(int index, int pagesize);

	List<User> findUser(String infoUser, int index, int pagesize);

	User getOne(int id);

	void editCustomer(User user);
}
