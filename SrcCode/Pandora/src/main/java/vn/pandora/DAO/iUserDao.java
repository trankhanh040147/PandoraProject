package vn.pandora.DAO;

import vn.pandora.Model.User;

public interface iUserDao {
void Add(User user);
void Insert(User user);
void Delete(User user);
User GetOne(User user);
User GetAll(User user);
}
