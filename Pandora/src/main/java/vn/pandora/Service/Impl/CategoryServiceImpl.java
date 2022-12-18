package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iCategoryDao;
import vn.pandora.DAO.Impl.CategoryDaoImpl;
import vn.pandora.Model.Category;
import vn.pandora.Service.iCategoryService;

public class CategoryServiceImpl implements iCategoryService {

	iCategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public List<Category> getAll(int index, int pagesize) {

		return categoryDao.getAll(index, pagesize);
	}

	@Override
	public Category getOne(int id) {

		return categoryDao.getOne(id);
	}

	@Override
	public void insert(Category category) {

		categoryDao.insert(category);
	}

	@Override
	public void update(Category category) {

		categoryDao.update(category);
	}

	@Override
	public void delete(int id) {

		categoryDao.delete(id);
	}

}
