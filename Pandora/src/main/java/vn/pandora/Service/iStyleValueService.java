package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.StyleValue;

public interface iStyleValueService {
	StyleValue getOne(int id);

	List<StyleValue> getAlLById(int id);
}
