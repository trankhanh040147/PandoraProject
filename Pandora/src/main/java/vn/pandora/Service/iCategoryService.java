package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.Category;

public interface iCategoryService {
	List<Category> getAll(int index, int pagesize);

	Category getOne(int id);

	void insert(Category category);

	void update(Category category);

	void delete(int id);
}
