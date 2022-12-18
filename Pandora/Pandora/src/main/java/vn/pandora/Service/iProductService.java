package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.Product;

public interface iProductService {
	void Add(Product product);

	void Update(Product product);

	void UpdateSelling(int id, Boolean isSelling);

	Product GetOne(int id);

	List<Product> GetAll(int index, int pagesize);

	List<Product> findTop_Promo(int index, int pagesize);

	List<Product> findTop_Created(int index, int pagesize);
}
