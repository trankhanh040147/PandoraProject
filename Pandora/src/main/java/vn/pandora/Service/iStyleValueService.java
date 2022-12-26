package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.StyleValue;

public interface iStyleValueService {
	StyleValue getOne(int id);

	List<StyleValue> getAlLById(int id);

	List<StyleValue> getAll(int index, int pagesize);

	void insert(StyleValue styleValue);

	void update(StyleValue styleValue);

	void delete(int id);
}
