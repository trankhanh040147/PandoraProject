package vn.pandora.Service;

import vn.pandora.Model.Cart;

public interface iCartService {
	void insert(Cart cart);

	Cart findLast();

	Cart findLastByUserId(int id);
}
