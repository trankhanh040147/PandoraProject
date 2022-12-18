package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iCategoryDao;

import vn.pandora.DAO.Impl.CategoryDaoImpl;
import vn.pandora.Model.Category;
import vn.pandora.Service.iCategoryService;

public class CategoryServiceImpl implements iCategoryService {
 iCategoryDao dao = new CategoryDaoImpl();
	@Override
	public Category getOne(int id) {
		
		return dao.getOne(id);
	}
	@Override
	public List<Category> getAll() {
		return dao.getAll();
	}

}
