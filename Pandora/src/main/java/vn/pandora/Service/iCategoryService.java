package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.Category;

public interface iCategoryService {
	Category getOne(int id);
	List<Category> getAll();
}
