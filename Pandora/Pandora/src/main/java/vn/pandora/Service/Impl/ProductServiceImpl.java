package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iProductDao;
import vn.pandora.DAO.Impl.ProductDaoImpl;
import vn.pandora.Model.Product;
import vn.pandora.Service.iProductService;

public class ProductServiceImpl implements iProductService {
	private ProductDaoImpl productDao = new ProductDaoImpl();

	@Override
	public void Add(Product product) {
		productDao.Add(product);

	}

	@Override
	public void Update(Product product) {
		productDao.Update(product);

	}

	@Override
	public void UpdateSelling(int id, Boolean isSelling) {
		productDao.UpdateSelling(id, isSelling);
	}

	@Override
	public Product GetOne(int id) {
		return productDao.GetOne(id);
	}

	@Override
	public List<Product> GetAll(int index, int pagesize) {
		return productDao.GetAll(index, pagesize);
	}

	@Override
	public List<Product> findTop_Promo(int index, int pagesize) {
		return productDao.findTop_Promo(index, pagesize);
	}

	@Override
	public List<Product> findTop_Created(int index, int pagesize) {
		return productDao.findTop_Created(index, pagesize);
	}
	

}
