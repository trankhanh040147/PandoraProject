package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.DAO.Impl.StyleValueDaoImpl;
import vn.pandora.Model.StyleValue;
import vn.pandora.Service.iStyleValueService;

public class StyleValueServiceImpl implements iStyleValueService {
	iStyleValueDao styleValueDao = new StyleValueDaoImpl();

	@Override
	public StyleValue getOne(int id) {
		return styleValueDao.getOne(id);
	}

	@Override
	public List<StyleValue> getAlLById(int id) {
		return styleValueDao.getAllById(id);
	}

	@Override
	public List<StyleValue> getAll(int index, int pagesize) {
		return styleValueDao.getAll(index, pagesize);
	}

	@Override
	public void insert(StyleValue styleValue) {
		styleValueDao.insert(styleValue);
		
	}

	@Override
	public void update(StyleValue styleValue) {
		styleValueDao.update(styleValue);
	}

	@Override
	public void delete(int id) {
		styleValueDao.delete(id);
		
	}

}
