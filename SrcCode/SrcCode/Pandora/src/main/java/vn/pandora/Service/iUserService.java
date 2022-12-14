package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.User;

public interface iUserService {
	// Guest: Đăng ký tạo tài khoản người dùng
	void insert(String firstname, String lastname, String id_card, String email, String phone, String password,
			String addresses, String avatar, String cover);

	// Guest: Xem/Tìm kiếm người dùng
	List<User> findUser(String infoUser, int index, int pagesize);

	User get(int id);

	// Admin: Xem danh sách người dùng trong hệ thống
	List<User> getAll(int index, int pagesize);
}
