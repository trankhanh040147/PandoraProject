package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Category;

public interface iCategoryDao {
	Category findById(int id);

	Category getOne(int id);

	List<Category> getAll();
}
