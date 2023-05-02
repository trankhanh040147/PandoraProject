package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.Category;

public interface iCategoryService {
	public Category findById(int id);

	Category getOne(int id);

	List<Category> getAll();
}