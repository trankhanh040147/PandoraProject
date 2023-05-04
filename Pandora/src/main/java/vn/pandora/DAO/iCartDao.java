package vn.pandora.DAO;

import vn.pandora.Model.Cart;

public interface iCartDao {
	void insert(Cart cart);

	Cart findLast();

	Cart findLastByUserId(int id);
}
