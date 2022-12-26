package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Style;
import vn.pandora.Model.StyleValue;

public interface iStyleValueDao {
	StyleValue getOne(int id);

	List<StyleValue> getAllById(int id);

	List<StyleValue> getAll(int index, int pagesize);

	void insert(StyleValue styleValue);

	void update(StyleValue styleValue);

	void delete(int id);
}
