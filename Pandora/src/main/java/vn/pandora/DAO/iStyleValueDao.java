package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.StyleValue;

public interface iStyleValueDao {
	StyleValue getOne(int id);
	List<StyleValue> getAllById(int id);
}
