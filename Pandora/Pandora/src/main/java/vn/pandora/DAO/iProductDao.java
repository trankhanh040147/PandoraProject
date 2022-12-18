package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Product;

public interface iProductDao {
	void Add(Product product);

	void Update(Product product);

	void UpdateSelling(int id, Boolean isSelling);

	Product GetOne(int id);

	List<Product> GetAll(int index, int pagesize);

	List<Product> findTop_Promo(int index, int pagesize);

	List<Product> findTop_Created(int index, int pagesize);

	void permit(Product product);

	void revoke(Product product);

}