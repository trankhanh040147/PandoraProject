package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Category;

public interface iCategoryDao {
	Category findById(int id);

	Category getOne(int id);

	List<Category> getAll();
	
	List<Category> getAll(int index, int pagesize);

	void insert(Category category);

	void update(Category category);

	void delete(int id);
}
