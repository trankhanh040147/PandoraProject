package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iCartItemDao;
import vn.pandora.DAO.Impl.CartItemDaoImpl;
import vn.pandora.Model.CartItem;
import vn.pandora.Service.iCartItemService;

public class CartItemServiceImpl implements iCartItemService {
	iCartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItem cartItem) {
		cartItemDao.insert(cartItem);
	}

	@Override
	public List<CartItem> findByCartId(int id) {
		return cartItemDao.findByCartId(id);
	}

	@Override
	public void update(CartItem cartItem) {
		cartItemDao.update(cartItem);
	}

	@Override
	public CartItem findOne(int id) {
		return cartItemDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		cartItemDao.delete(id);
	}

}
