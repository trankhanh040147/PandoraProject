package vn.pandora.Service.Impl;

import vn.pandora.DAO.iCartDao;
import vn.pandora.DAO.Impl.CartDaoImpl;
import vn.pandora.Model.Cart;
import vn.pandora.Service.iCartService;

public class CartServiceImpl implements iCartService {
	iCartDao cartDao = new CartDaoImpl();

	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);
	}

	@Override
	public Cart findLast() {
		return cartDao.findLast();
	}


	@Override
	public Cart findLastByUserId(int id) {
		return cartDao.findLastByUserId(id);
	}
	
}
