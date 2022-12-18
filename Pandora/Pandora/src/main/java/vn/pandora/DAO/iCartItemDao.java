package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.CartItem;

public interface iCartItemDao {
	void insert(CartItem cartItem);
	
	CartItem findOne(int id);

	List<CartItem> findByCartId(int id);
	
	void update(CartItem cartItem);

	void delete(int id);
}
