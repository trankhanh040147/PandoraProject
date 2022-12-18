package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Style;

public interface iStyleDao {
	List<Style> getAll(int index, int pagesize);

	Style getOne(int id);

	void insert(Style style);

	void update(Style style);

	void delete(int id);
}
