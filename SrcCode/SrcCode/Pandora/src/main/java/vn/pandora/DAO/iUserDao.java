package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.User;

public interface iUserDao {
//	void Add(User user);

//	void Insert(User user);

//	void Delete(User user);

//	User GetOne(User user);

//	User GetAll(User user);

	// Guest: Đăng ký tạo tài khoản người dùng
	void insert(String firstname, String lastname, String id_card, String email, String phone, String password,
			String addresses, String avatar, String cover);

	// Guest: Xem/Tìm kiếm người dùng
	List<User> findUser(String infoUser, int index, int pagesize);

	User get(int id);

	// Admin: Xem danh sách người dùng trong hệ thống
	List<User> getAll(int index, int pagesize);
}
