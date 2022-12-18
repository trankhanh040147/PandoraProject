package vn.pandora.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import vn.pandora.DAO.iCategoryDao;
import vn.pandora.DAO.iOrderDao;
import vn.pandora.DAO.iOrderItemDao;
import vn.pandora.DAO.iProductDao;
import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.Util.UtilClass;

public class aTestDao {

	public static void main(String[] args) {
		iCategoryDao service = new CategoryDaoImpl();
//		ProductDaoImpl dao = new ProductDaoImpl();
//		List<Integer> kString= new ArrayList<Integer>();
//		kString.add(1);
//		kString.add(1);
//		kString.add(3);
//		System.out.println(dao.GetAll(0, 7));
		
		System.out.println(service.getOne(6).getName());
		
	}

}
