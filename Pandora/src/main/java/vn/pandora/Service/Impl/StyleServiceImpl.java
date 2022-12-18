package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iStyleDao;
import vn.pandora.DAO.Impl.StyleDaoImpl;
import vn.pandora.Model.Style;
import vn.pandora.Service.iStyleService;

public class StyleServiceImpl implements iStyleService {

	iStyleDao styleDao = new StyleDaoImpl();
	
	@Override
	public List<Style> getAll(int index, int pagesize) {
		
		return styleDao.getAll(index, pagesize);
	}

	@Override
	public Style getOne(int id) {
		
		return styleDao.getOne(id);
	}

	@Override
	public void insert(Style style) {
		
		styleDao.insert(style);
	}

	@Override
	public void update(Style style) {
		
		styleDao.update(style);
	}

	@Override
	public void delete(int id) {
		
		styleDao.delete(id);
	}

}
