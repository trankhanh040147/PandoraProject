package vn.pandora.Service.Impl;

import java.util.List;

import vn.pandora.DAO.iStoreDao;
import vn.pandora.DAO.Impl.StoreDaoImpl;
import vn.pandora.Model.Store;
import vn.pandora.Service.iStoreService;

public class StoreServiceImpl implements iStoreService {
    private StoreDaoImpl storeDao = new StoreDaoImpl();
	@Override
	public void Add(Store store) {
		storeDao.Add(store);
	}

	@Override
	public void Update(Store store) {
		storeDao.Update(store);
		
	}

	@Override
	public Store GetOne(int id) {
		
		return storeDao.GetOne(id);
	}

	@Override
	public void UpdateWallet(int id, double mount) {
		storeDao.UpdateWallet(id, mount);
		
	}

	@Override
	public List<Integer> GetIdSrore(int id) {
		
		return storeDao.GetIdSrore(id);
	}

	@Override
	public List<Store> GetStoreByownerId(int id) {
		
		return storeDao.GetStoreByownerId(id);
	}

}