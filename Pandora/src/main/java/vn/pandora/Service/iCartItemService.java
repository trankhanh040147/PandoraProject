package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.CartItem;

public interface iCartItemService {
	void insert(CartItem cartItem);
	
	CartItem findOne(int id);

	List<CartItem> findByCartId(int id);

	void update(CartItem cartItem);

	void delete(int id);
}
