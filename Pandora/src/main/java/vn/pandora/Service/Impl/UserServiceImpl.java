package vn.pandora.Service.Impl;

import java.io.File;
import java.util.List;

import vn.pandora.DAO.iUserDao;
import vn.pandora.DAO.Impl.UserDaoImpl;
import vn.pandora.Model.User;
import vn.pandora.Service.iUserService;
import vn.pandora.Util.Constant;

public class UserServiceImpl implements iUserService {

	iUserDao userDao = new UserDaoImpl();

	@Override
	public User login(String email, String passwd) {
		return userDao.login(email, passwd);
	}

	@Override
	public User findByEmail(String username) {
		return userDao.findByEmail(username);
	}

	@Override
	public void registerCustomer(User user) {
		userDao.registerCustomer(user);

	}

	@Override
	public void registerVendor(User user) {
		userDao.registerVendor(user);
	}

	@Override
	public List<User> getAll(int index, int pagesize) {
		return userDao.getAll(index, pagesize);
	}

	@Override
	public List<User> findUser(String infoUser, int index, int pagesize) {
		return userDao.findUser(infoUser, index, pagesize);
	}

	@Override
	public User getOne(int id) {
		return userDao.getOne(id);
	}

	@Override
	public void editCustomer(User newUserInfo) {
		User oldUserInfo = userDao.findById(newUserInfo.getId());
		oldUserInfo.setFirstname(newUserInfo.getFirstname());
		if (newUserInfo.getAvatar() != null) {
			// XOA ANH CU DI
			String fileName = oldUserInfo.getAvatar();
			final String dir = Constant.DIR;
			File file = new File(dir + "/avatar" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldUserInfo.setAvatar(newUserInfo.getAvatar());
		}
		userDao.editCustomer(newUserInfo);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

}
