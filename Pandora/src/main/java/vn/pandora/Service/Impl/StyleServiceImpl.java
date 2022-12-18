package vn.pandora.Service.Impl;

import vn.pandora.DAO.iStyleDao;
import vn.pandora.DAO.Impl.StyleDaoImpl;
import vn.pandora.Model.Style;
import vn.pandora.Service.iStyleService;

public class StyleServiceImpl implements iStyleService{
	iStyleDao styleDao = new StyleDaoImpl();
	
	@Override
	public Style getOne(int id) {
		return styleDao.getOne(id);
	}

}
