package vn.pandora.DAO;

import vn.pandora.Model.Store;

public interface iStoreDao {
void Add(Store store);
void Update(Store store );
Store GetOne(int id);
void UpdateWallet(int id, double mount);
}
