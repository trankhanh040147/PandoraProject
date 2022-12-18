package vn.pandora.Service.Impl;

import vn.pandora.DAO.iCategoryDao;
import vn.pandora.DAO.Impl.CategoryDaoImpl;
import vn.pandora.Model.Category;
import vn.pandora.Service.iCategoryService;

public class CategoryServiceImpl implements iCategoryService {

	iCategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public Category findById(int id) {
		return categoryDao.findById(id);
	}

}
