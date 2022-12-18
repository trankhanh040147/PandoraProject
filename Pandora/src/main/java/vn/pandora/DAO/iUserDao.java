package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.User;

public interface iUserDao {

	User login(String email, String passwd);

	User findByEmail(String email);

	void registerCustomer(User user);

	void registerVendor(User user);

	List<User> getAll(int index, int pagesize);

	List<User> findUser(String infoUser, int index, int pagesize);

	User getOne(int id);

	void editCustomer(User user);

	User findById(int id);
}
