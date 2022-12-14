package vn.pandora.Service;

import vn.pandora.Model.Store;

public interface iStoreService {
	void Add(Store store);
	void Update(Store store );
	Store GetOne(int id);
	void UpdateWallet(int id, double mount);
}
