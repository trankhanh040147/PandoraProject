package vn.pandora.Util;

import java.util.ArrayList;
import java.util.List;

import vn.pandora.DAO.iProductDao;
import vn.pandora.DAO.iStyleValueDao;
import vn.pandora.DAO.Impl.ProductDaoImpl;
import vn.pandora.Model.Product;
import vn.pandora.Model.StyleValue;
import vn.pandora.Service.iCartItemService;
import vn.pandora.Service.iCartService;
import vn.pandora.Service.iCategoryService;
import vn.pandora.Service.iProductService;
import vn.pandora.Service.iStyleValueService;
import vn.pandora.Service.Impl.CartItemServiceImpl;
import vn.pandora.Service.Impl.CartServiceImpl;
import vn.pandora.Service.Impl.CategoryServiceImpl;
import vn.pandora.Service.Impl.ProductServiceImpl;
import vn.pandora.Service.Impl.StyleValueServiceImpl;

public class TestClass {

	public static void main(String[] args) {
		iCartItemService cartService = new CartItemServiceImpl();
		cartService.delete(9);
	}

}
