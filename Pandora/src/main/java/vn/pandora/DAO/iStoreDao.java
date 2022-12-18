package vn.pandora.DAO;

import java.util.List;

import vn.pandora.Model.Store;

public interface iStoreDao {
	void Add(Store store);

	void Update(String name, String boi, boolean isOpen,String avatar, String cover, String featured_image,int id);

	void Update(Store store);

	Store GetOne(int id);

	List<Integer> GetIdSrore(int id);

	List<Store> GetStoreByownerId(int id);

	void UpdateWallet(int id, double mount);
	
	List<Store> getAll(int index, int pagesize);
	
	void permit(Store store);
	
	void revoke(Store store);
	
}
