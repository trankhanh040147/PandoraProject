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
	public void Update(String name, String boi, boolean isOpen, String avatar, String cover, String featured_image,
			int id) {
		storeDao.Update(name, boi, isOpen, avatar, cover, featured_image, id);
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

	@Override
	public void Update(Store store) {
		storeDao.Update(store);
	}

	@Override
	public List<Store> getAll(int index, int pagesize) {
		return storeDao.getAll(index, pagesize);
	}

	@Override
	public void permit(Store store) {
		storeDao.permit(store);

	}

	@Override
	public void revoke(Store store) {
		storeDao.revoke(store);

	}

}