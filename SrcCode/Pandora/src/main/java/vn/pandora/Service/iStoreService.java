package vn.pandora.Service;

import java.util.List;

import vn.pandora.Model.Store;

public interface iStoreService {
	void Add(Store store);
	void Update(Store store );
	Store GetOne(int id);
	void UpdateWallet(int id, double mount);
	List<Integer> GetIdSrore(int id);
	List<Store> GetStoreByownerId(int id);
}
