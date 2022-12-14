package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iUserDao;
import vn.pandora.DAO.Impl.UserDaoImpl;
import vn.pandora.Model.User;
import vn.pandora.Service.iUserService;

public class UserServiceImpl implements iUserService {

	iUserDao userDao = new UserDaoImpl();

	@Override
	public List<User> getAll(int index, int pagesize) {
		return userDao.getAll(index, pagesize);
	}

	@Override
	public void insert(String firstname, String lastname, String id_card, String email, String phone, String password,
			String addresses, String avatar, String cover) {
		userDao.insert(firstname, lastname, id_card, email, phone, password, addresses, avatar, cover);
	}

	@Override
	public List<User> findUser(String infoUser, int index, int pagesize) {
		return userDao.findUser(infoUser, index, pagesize);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

}
